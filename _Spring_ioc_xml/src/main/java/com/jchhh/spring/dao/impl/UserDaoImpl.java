package com.jchhh.spring.dao.impl;

import com.jchhh.spring.dao.UserDao;

public class UserDaoImpl implements UserDao {
    @Override
    public void saveUser() {
        System.out.println("保存成功!");
    }
}
