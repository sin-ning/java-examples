package com.joysrun.bean.examples.reference;

import org.junit.Test;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

/**
 * author: sin
 * time: 2019-08-20 11:02
 */
public class SoftReferenceTest {
    private static List<Object> list = new ArrayList<>();

    @Test
    public void softReferenceTest() {
        for (int i = 0; i < 10; i++) {
            byte[] buff = new byte[1024 * 1024];
            SoftReference<byte[]> sr = new SoftReference<>(buff);
            list.add(sr);
        }

        System.gc(); //主动通知垃圾回收

        for(int i=0; i < list.size(); i++){
            Object obj = ((SoftReference) list.get(i)).get();
            System.out.println(obj);
        }
    }
}
