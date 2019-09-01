package com.joysrun.spring.examples.container;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericGroovyApplicationContext;

/**
 * author: sin
 * time: 2019/8/29 10:29 下午
 */
public class SpringContainerTest {

    @Test
    public void xmlContainerInitTest() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:container/bean.xml");
        System.err.println("Container count: " + applicationContext.getBeanDefinitionCount());
        Assert.assertTrue("容器文件为加载到!", applicationContext.getBeanDefinitionCount() > 0);
    }

    @Test
    public void genericApplicationContextTest() {
        GenericApplicationContext context = new GenericApplicationContext();
        new XmlBeanDefinitionReader(context).loadBeanDefinitions("classpath:container/bean.xml");
        context.refresh();
    }

    public static void main(String[] args) {
        GenericApplicationContext context = new GenericApplicationContext();
        new XmlBeanDefinitionReader(context).loadBeanDefinitions("classpath:container/bean.xml");
        context.refresh();

        System.err.println("Container Count: " + context.getBeanDefinitionCount());
    }
}
