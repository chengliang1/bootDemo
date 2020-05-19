package com.czxy.boot_demo.service.impl;

import com.czxy.boot_demo.entity.Account;
import com.czxy.boot_demo.mapper.AccountMapper;
import com.czxy.boot_demo.service.AccountService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;


    /**
     *
     * @param id
     * @return
     */
    @Override
    public Account AllResult(int id) {
        return accountMapper.AllResult(id);
    }

    /**
     *
     * @param userName
     * @param password
     * @return
     */
    public Account login(String userName,String password){
        Account account = accountMapper.login(userName);
        if (account != null && password.equals(account.getPassword())){
            return account;
        }
        else {
            return null;
        }
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public int deleteAccount(Integer id) {
        return accountMapper.deleteAccount(id);
    }


    /**
     *
     * @return
     */
    public List<Account> findAll(){
        List<Account> accounts = accountMapper.findAll();
        return accounts;
    }


   /* @Test
    public static void main(String[] args) {

        AccountServiceImpl accountService = new AccountServiceImpl();

        Account account = accountService.AllResult(1);
        System.out.println(account);
    }*/
}
