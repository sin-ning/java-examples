package com.joysrun.bean.examples.oop;

import com.joysrun.bean.examples.oop.obj.Person;
import com.joysrun.bean.examples.oop.obj.Student;
import com.joysrun.bean.examples.oop.obj.Worker;
import org.junit.Before;
import org.junit.Test;

/**
 * author: sin
 * time: 2019-08-20 00:04
 */
public class OOPTest {

    Person person = new Person();
    Student student = new Student();

    @Before
    public void setup() {
        student.school = "北大清华";
        student.name = "王明";
        student.gender = "男";

        person.name = "小男孩";
        person.gender = "男";
    }

    @Test
    public void castUpTest() {
        // cast uo
//        Person person = student;
//        System.err.println(student);
//        System.err.println(person);

        Person person1 = new Person();
        Student student = (Student) person1;
    }

    @Test
    public void castBrotherTest() {
        Person person = student;
        Worker worker = (Worker) person;

        System.err.println(person);
        System.err.println(worker);
    }

    @Test
    public void castChildrenTest() {
        Worker worker = (Worker) person;
        System.err.println(person);
        System.err.println(worker);
    }
}
