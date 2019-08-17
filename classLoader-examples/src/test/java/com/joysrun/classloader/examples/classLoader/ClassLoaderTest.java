package com.joysrun.classloader.examples.classLoader;

import org.junit.Test;

/**
 * author: sin
 * time: 2019-08-17 11:05
 */
public class ClassLoaderTest {

    @Test
    public void classLoaderTest() {
        System.err.println("System classLoader: " + ClassLoader.getSystemClassLoader());
    }

    @Test
    public void classForNameTest() {
        try {
            Class.forName("com.joysrun.classloader.examples.classLoader.ClassLoaderTest").newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void myClassLoaderTest() {
        try {
            String className = "com.joysrun.classloader.examples.classLoader.ClassLoaderTest";

            ClassLoaderTest loaderTest = (ClassLoaderTest) new MyClassLoader().loadClass(className).newInstance();

            System.err.println("Loader obj: " + loaderTest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyClassLoader extends ClassLoader {

        public MyClassLoader() {
             super();
            // super 如果设置为 null，Bootstrap 加载器不能加载 classPath 的 class 文件
            // super(null);
        }

        @Override
        protected Class<?> findClass(String name) throws ClassNotFoundException {
            return super.findClass(name);
        }
    }
}
