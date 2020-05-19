package com.czxy.boot_demo.entity;

import lombok.Data;

@Data
public class Account {

    private Integer id;

    private String userName;

    private String password;

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
