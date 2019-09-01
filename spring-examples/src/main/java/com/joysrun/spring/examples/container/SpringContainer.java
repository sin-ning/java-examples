package com.joysrun.spring.examples.container;

import com.joysrun.spring.examples.container.beans.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring 容器
 *
 * author: sin
 * time: 2019/8/29 9:23 下午
 */
public class SpringContainer {

    public static void main(String[] args) {
//        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext();
//        FileSystemXmlApplicationContext fileSystemXmlApplicationContext = new FileSystemXmlApplicationContext();
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("container/bean.xml");
        System.err.println(applicationContext.getBeanDefinitionNames());
        User user = (User) applicationContext.getBean("user");
        System.err.println(user);
    }
}
