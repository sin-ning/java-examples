package com.joysrun.dynamic.proxy.examples;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * author: sin
 * time: 2019-08-19 15:59
 */
public class DynamicProxyTest {

    @Test
    public void dynamicProxyTest() {
        User user = new AdminUser();
        UserProxy userProxy = new UserProxy(user);
        User user1 = (User) Proxy.newProxyInstance(user.getClass().getClassLoader(), new Class[]{IU.class, User.class}, userProxy);
        System.err.println(user1.getName());

        // user
        UserProxy iu = new UserProxy(new UX());
        IU iu1 = (IU) Proxy.newProxyInstance(user.getClass().getClassLoader(), new Class[]{IU.class, User.class}, iu);
        iu1.show();
    }

    @Test
    public void interfaceNewInstanceTest() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        IU iu = IU.class.getConstructor().newInstance();
        iu.show();
    }

    @Test
    public void proxyGeneratorTest() throws IOException {
        byte[] classFile = ProxyGenerator.generateProxyClass("$Proxy0", UX.class.getInterfaces());
        String path = "/Users/sin/Downloads/IU.$Proxy0.class";
        FileUtils.writeByteArrayToFile(new File(path), classFile);
    }

    /// User

    interface IU {
        void show();

        void showName();
    }

    static class UX implements IU {

        @Override
        public void show() {
            System.err.println("IU...");
        }

        @Override
        public void showName() {
            System.err.println("show name...");
        }
    }

    interface User {
        String getName();
    }

    static class AdminUser implements User {

        @Override
        public String getName() {
            return "admin user.";
        }
    }

    static class UserProxy implements InvocationHandler {

        private Object user;

        public UserProxy(Object user) {
            this.user = user;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("--------------begin-------------");
            Object result = method.invoke(user, args);
            System.err.println("invoker result: " + result);
            System.out.println("--------------end-------------");
            return result;
        }
    }
}
