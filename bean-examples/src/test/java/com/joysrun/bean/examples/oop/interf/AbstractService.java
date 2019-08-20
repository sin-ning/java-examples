package com.joysrun.bean.examples.oop.interf;

/**
 * author: sin
 * time: 2019-08-20 08:41
 */
public abstract class AbstractService implements IService {

    public static final int s1 = 100;

    protected static final int s2 = 200;

    static final int s3 = 300;

    public AbstractService() {

    }

    private AbstractService(String name) {

    }

    public abstract void showName2();
}
