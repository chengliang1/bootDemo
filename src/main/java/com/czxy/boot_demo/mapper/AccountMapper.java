package com.czxy.boot_demo.mapper;

import com.czxy.boot_demo.entity.Account;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountMapper {

    Account AllResult(int id);

    Account login(String userName);

    List<Account> findAll();

    int deleteAccount(Integer id);
}
