package com.joysrun.bean.examples.interf;

/**
 * author: sin
 * time: 2019-08-20 09:30
 */
public class BaseService extends AbstractService {

    public void show() {
        System.err.println("s2: " + BaseService.s2);
        System.err.println("s3: " + BaseService.s3);
    }
}
