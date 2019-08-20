package com.joysrun.bean.examples.reference;

import org.junit.Test;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * java 引用测试
 *
 * 需要设置内存大小：JVM 参数 -Xms2M -Xmx3M
 *
 * author: sin
 * time: 2019-08-20 11:02
 */
public class SoftReferenceTest {
    private static List<Object> list = new ArrayList<>();

    @Test
    public void strongReferenceTest() {
        for (int i = 0; i < 10; i++) {
            System.err.println(i);
            byte[] buff = new byte[500 * 1024];
            list.add(buff);
        }

        //主动通知垃圾回收
        System.gc();

        for(int i=0; i < list.size(); i++){
            Object obj = list.get(i);
            System.out.println(obj);
        }
    }

    @Test
    public void softReferenceTest() {
        for (int i = 0; i < 10; i++) {
            System.err.println(i);
            byte[] buff = new byte[500 * 1024];
            SoftReference<byte[]> sr = new SoftReference<>(buff);
            list.add(sr);
        }

        //主动通知垃圾回收
        System.gc();

        for(int i=0; i < list.size(); i++){
            Object obj = ((SoftReference) list.get(i)).get();
            System.out.println(obj);
        }
    }

    @Test
    public void weakReferenceTest() {
        for (int i = 0; i < 10; i++) {
            System.err.println(i);
            byte[] buff = new byte[500 * 1024];
            WeakReference<byte[]> sr = new WeakReference<>(buff);
            list.add(sr);
        }

        //主动通知垃圾回收
        System.gc();

        for(int i=0; i < list.size(); i++){
            Object obj = ((WeakReference) list.get(i)).get();
            System.out.println(obj);
        }
    }
}
