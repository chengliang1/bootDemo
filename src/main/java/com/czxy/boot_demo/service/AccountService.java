package com.czxy.boot_demo.service;

import com.czxy.boot_demo.entity.Account;

import java.util.List;

public interface AccountService {

    public Account AllResult(int id);

    Account login(String userame,String password);

    List<Account> findAll();

    int deleteAccount(Integer id);
}
