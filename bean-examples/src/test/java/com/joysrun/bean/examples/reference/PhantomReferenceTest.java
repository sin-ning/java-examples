package com.joysrun.bean.examples.reference;

import org.junit.Test;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.List;

/**
 * author: sin
 * time: 2019-08-20 13:25
 */
public class PhantomReferenceTest {

    private static List<Object> list = new ArrayList<>();

    @Test
    public void referenceQueueTest() {
        ReferenceQueue queue = new ReferenceQueue<String>();
        for (int i = 0; i < 10; i++) {
            PhantomReference pr = new PhantomReference<String>(String.valueOf(i), queue);
            list.add(pr);
        }

        System.gc();

        int mxFor = 100;
        for (;;) {
            mxFor++;
            if (mxFor >= 100) {
                break;
            }
            Reference reference = queue.poll();

            if (reference == null) {
                continue;
            }
            System.err.println(reference.get());
        }
    }

    @Test
    public void intTest() {
        Integer b3 = 128;
        Integer b4 = 128;
        System.err.println(b3 == b4);

        // Integer 缓存值 -128 >= <= 127
        for (int i = 0; i < 200; i++) {
            Integer i2 = i;
            Integer i3 = i;
            System.err.println("i = " + i + " > " + String.valueOf(i3 == i2));
        }
    }

    @Test
    public void intTest2() {
        Integer a = 120;
        int b= 120;
        Integer c = 120;
        Integer d = new Integer(120);
        System.out.println(a == b);   //true    t1
        System.out.println(a == c);   //true    t2
        System.out.println(a == d);   //false   t3

        Integer e = 128;
        Integer f = 128;
        System.out.println(e == f);   //false    t4
    }
}
