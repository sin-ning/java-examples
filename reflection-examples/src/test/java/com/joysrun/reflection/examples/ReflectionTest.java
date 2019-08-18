package com.joysrun.reflection.examples;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * author: sin
 * time: 2019-08-18 19:37
 */
public class ReflectionTest {

    @Test
    public void constructorNewInstanceTest() throws IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor<?>[] constructors = InternalObject.class.getConstructors();
        System.err.println("constructor size: " + constructors.length);

        // newInstance
        List<InternalObject> internalObjects = newInstance(constructors);
        for (InternalObject internalObject : internalObjects) {
            System.err.println("internal init value: " + internalObject.init);
        }
    }

    private List<InternalObject> newInstance(Constructor<?>[] constructors) throws InstantiationException, IllegalAccessException, InvocationTargetException {
        List<InternalObject> internalObjectList = new ArrayList<>(constructors.length);
        for (Constructor<?> constructor : constructors) {
            System.err.println(constructor.getParameterCount());
            if (constructor.getParameterCount() == 1) {
                internalObjectList.add((InternalObject) constructor.newInstance(100));
            } else {
                internalObjectList.add((InternalObject) constructor.newInstance());
            }
        }
        return internalObjectList;
    }

    @Test
    public void classNewInstanceTest() throws IllegalAccessException, InstantiationException {
        // 反射初始化对象，必须获取到 Class 对象信息
        ReflectionTest reflectionTest = ReflectionTest.class.newInstance();
        // isInstance 判断是否是，这个类型 和 if instance 效果一直
        System.err.println(ReflectionTest.class.isInstance(reflectionTest));
    }


    // test class

    public static class InternalObject {
        private int init = -1;

        public InternalObject() {

        }

        public InternalObject(int init) {
            this.init = init;
        }

    }
}
