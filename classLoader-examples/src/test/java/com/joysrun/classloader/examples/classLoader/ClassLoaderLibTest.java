package com.joysrun.classloader.examples.classLoader;

import org.junit.Test;

import java.net.URL;
import java.net.URLClassLoader;

/**
 * 类加载器 lib，加载情况
 *
 * author: sin
 * time: 2019-08-17 10:51
 */
public class ClassLoaderLibTest {

    @Test
    public void bootstrapClassLoaderLibTest() {
        // 启动加载器：加载目录 JAVA_HOME/lib
        ClassLoader classLoader = ClassLoader.getSystemClassLoader().getParent().getParent();
        URL[] urLs = ((URLClassLoader) classLoader).getURLs();
        System.err.println("classLoader: " + classLoader);
        for (URL urL : urLs) {
            System.err.println(urL);
        }
    }

    @Test
    public void extensionClassLoaderLibTest() {
        // 启动加载器：加载目录 JAVA_HOME/lib/ext
        // 系统参数: java.ext.dir
        ClassLoader classLoader = ClassLoader.getSystemClassLoader().getParent();
        URL[] urLs = ((URLClassLoader) classLoader).getURLs();
        System.err.println("classLoader: " + classLoader);
        for (URL urL : urLs) {
            System.err.println(urL);
        }
    }

    @Test
    public void appClassLoaderLibTest() {
        // 启动加载器：加载目录 CLASS_PATH
        // 系统参数: java.class.path
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        URL[] urLs = ((URLClassLoader) classLoader).getURLs();
        System.err.println("classLoader: " + classLoader);
        for (URL urL : urLs) {
            System.err.println(urL);
        }
    }
}
