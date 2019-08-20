package com.joysrun.bean.examples.interf;

/**
 * author: sin
 * time: 2019-08-20 08:16
 */
public interface IService {

    // 默认修饰 static final，只写 static 也是 static final
    static final int count = 100;
    static int modify = 100;

    int b = 10;

    static String text = "字符串...";

    void showName();

    /**
     * interface 的内部类，跟普通类一致，除了默认的修饰 "public static"
     *
     * 描述：
     *
     * 内部的类，和普通类拥有的特性一致，并没有跟 interface 中一样，会有默认的修饰。
     */
    public static class Inner {

        public int innerA = 100;

        protected int innerB = 200;

        private void show() {
            System.err.println("Inner...");
        }
    }

    public static enum Type {

    }
}
