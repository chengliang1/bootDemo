package com.czxy.boot_demo.controller;

import com.czxy.boot_demo.entity.Account;
import com.czxy.boot_demo.service.AccountService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class AccountController {


    @Autowired
    private AccountService accountService;

    /**
     * 跳转登录页、后期加入security可省略
     * @return
     */
    @RequestMapping("/")
    public String homePage(){
        return "login";
    }

    /**
     *
     * @param account
     * @param model
     * @param userName
     * @param password
     * @param map
     * @return
     */
    @RequestMapping("/account/login")
    public String login(Account account, Model model, @RequestParam("userName") String userName, @RequestParam("password") String password, Map<String,Object> map){
        Account result = accountService.login(userName, password);
        if (result != null){
            model.addAttribute(result);
            return "user/index";
        }
        else {
            map.put("msg","用户名或密码错误");
            return "login";
        }

    }

    /**
     *
     * @param model
     * @return
     */
    @RequestMapping("/accounts")
    public String findAll(Model model){
        List<Account> accounts = accountService.findAll();
        model.addAttribute("account",accounts);
        return "user/index";
    }

    /**
     *
     * @return
     */
    @RequestMapping("/edit")
    public String edit(){
        return "user/edit";
    }

    @RequestMapping("/delete/{Id}")
    public String deleteAccount(@PathVariable("Id") Integer id,HttpServletRequest request){
        System.out.println(request.getParameter("aa"));
        accountService.deleteAccount(id);
        return "redirect:accounts";
    }

    @RequestMapping("getAll/{id}")
    @ResponseBody
    public String getAllAccount(@PathVariable int id, HttpServletRequest request){

        return accountService.AllResult(id).toString();
    }





}
