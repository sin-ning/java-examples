package com.joysrun.bean.examples;

import com.joysrun.bean.examples.interf.AbstractService;
import com.joysrun.bean.examples.interf.BaseService;
import org.junit.Test;

/**
 * author: sin
 * time: 2019-08-20 09:08
 */
public class AbstractTest {

    @Test
    public void absConstructorTest() {

        // 抽闲类不能被 new
//        new AbstractService();

        System.err.println("s1: " + AbstractService.s1);

        //
        BaseService baseService = new BaseService();
        System.err.println(BaseService.s1);
    }
}
