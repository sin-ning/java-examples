package com.joysrun.reflection.examples;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * author: sin
 * time: 2019-08-18 22:02
 */
public class Outer {

    private int count = 100;

    private String name = "Sin";

    private Object object = new Object();

    @Test
    public void invokerAccess000Test() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Inner inner = new Inner();

        // 调用不到 access$000
        Method access$000 = Inner.class.getDeclaredMethod("access$000", Outer.class);
        access$000.invoke(inner, Outer.class.newInstance());
    }

    @Test
    public void invokerAccess111Test() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Inner inner = new Inner();

        // 调用不到 access$000
        Method access$000 = Inner.class.getDeclaredMethod("access$100", Outer.class);
        access$000.invoke(inner, Outer.class.newInstance());
    }

    @Test
    public void showAllMethodTest() {
        for (Method method : Outer.class.getDeclaredMethods()) {
            System.err.println(method);
        }
    }

    /// 自定义 access$xxx

//    static int access$100(Outer outer) {
//        System.err.println("access$111...");
//        return 1;
//    }
//
//    static int access$000(Outer outer) {
//        return 1;
//    }

    /// Inner

    class Inner {

        private int innerCount = 300;

        private void show() {
            System.err.println("InternalObject show..." + count);
        }

        public int getCount() {
            return count;
        }

        public String getName() {
            return name;
        }

        public Object getObject() {
            return object;
        }


        class InnerX {

            public Object getObject() {
                return object;
            }

            public int getInnerCount() {
                return innerCount;
            }
        }
    }
}
