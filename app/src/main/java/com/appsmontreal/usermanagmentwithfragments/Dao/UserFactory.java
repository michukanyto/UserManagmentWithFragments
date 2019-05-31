package com.appsmontreal.usermanagmentwithfragments.Dao;

public class UserFactory {

    private UserDao userDao = new UserDao();

    public UserDao getUserDao() {
        return userDao;
    }
}
