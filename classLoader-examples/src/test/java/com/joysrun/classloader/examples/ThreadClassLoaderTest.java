package com.joysrun.classloader.examples;

import org.junit.Test;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * author: sin
 * time: 2019-08-17 11:31
 */
public class ThreadClassLoaderTest {

    @Test
    public void threadTest() {
        System.err.println("Thread context classLoader: " + Thread.currentThread().getContextClassLoader());
    }

    @Test
    public void jdbcTest() {
        try {
            // Required for Class.forName().newInstance()
            // Class.forName("com.mysql.jdbc.Driver");
            String connUrl = "jdbc:mysql://127.0.0.1:3306/joysrun_system?useSSL=false&useUnicode=true&characterEncoding=UTF-8";
            String name = "root";
            String password = "root";
            DriverManager.getConnection(connUrl, name, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
