package com.joysrun.bean.examples.oop;

import com.joysrun.bean.examples.oop.interf.IService;
import com.joysrun.bean.examples.oop.interf.UserService;
import org.junit.Test;

/**
 * author: sin
 * time: 2019-08-20 08:24
 */
public class InterfaceTest {

    @Test
    public void accessInnerFieldTest() {
        IService.Inner inner = new IService.Inner();

        System.err.println(inner.innerA);
        inner.innerA = 999;
        System.err.println(inner.innerA);
    }

    @Test
    public void accessFieldTest() {
        IService iService = new UserService();

        // 默认访问权限是 public
        iService.showName();

        // 默认权限也是 public
        System.err.println("a: " + IService.modify);
        System.err.println("count: " + IService.count);

        // 修改属性
        System.err.println();
    }
}
