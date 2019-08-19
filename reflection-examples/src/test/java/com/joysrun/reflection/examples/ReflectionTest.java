package com.joysrun.reflection.examples;

import org.junit.Test;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * author: sin
 * time: 2019-08-18 19:37
 */
public class ReflectionTest {

    @Test
    public void mapDataTest() throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        Field field = InternalObject.class.getDeclaredField("data");
        field.setAccessible(true);

        InternalObject internalObject = InternalObject.class.newInstance();
        Map<String, String> data = (Map<String, String>) field.get(internalObject);
        for (int i = 0; i < 10; i++) {
            data.put(String.valueOf(i), String.valueOf(i));
        }

        // 设置 data
        field.set(internalObject, data);

//        for (Map.Entry<String, String> entry : data.entrySet()) {
//            System.err.println(entry);
//        }

        System.err.println(internalObject);
    }

    @Test
    public void arrayNewInstanceTest() {
        int size = 10;
        String[] names = (String[]) Array.newInstance(String.class, size);
        for (int i = 0; i < size; i++) {
            names[i] = String.valueOf(i);
        }
        for (String name : names) {
            System.err.println("name: " + name);
        }
    }

    @Test
    public void privateMethodInvokerTest() throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        System.err.println("All method...");

        for (Method declaredMethod : InternalObject.class.getDeclaredMethods()) {
            System.err.println(declaredMethod);
        }

        System.err.println("Invoker private method.");
        InternalObject internalObject = InternalObject.class.newInstance();
        Method showMethod = InternalObject.class.getDeclaredMethod("show");

        // private access set true
        showMethod.setAccessible(true);
        showMethod.invoke(internalObject);
    }

    @Test
    public void constructorNewInstance2Test() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        InternalObject internalObject = InternalObject.class.getConstructor(Integer.class).newInstance(200);
        System.err.println(internalObject.init);
    }

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
        private Integer init = -1;

        private Map<String, String> data = new HashMap<>();

        public InternalObject() {

        }

        public InternalObject(Integer init) {
            this.init = init;
        }

        private void show() {
            System.err.println("show method...");
        }

        @Override
        public String toString() {
            return "InternalObject{" +
                    "init=" + init +
                    ", data=" + data +
                    '}';
        }
    }
}
