package com.joysrun.bean.examples.interf;

/**
 * author: sin
 * time: 2019-08-20 08:24
 */
public class UserService implements IService {

    @Override
    public void showName() {
        System.err.println("User service...");
    }
}
