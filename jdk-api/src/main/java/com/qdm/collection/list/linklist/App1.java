package com.qdm.collection.list.linklist;

import com.qdm.data.po.Student;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
/**
 * @author qiudm
 * @date 2019/1/7 9:44
 * @desc
 */
public class App1 {

    private LinkedList<Student> studentList = null;

    @Before
    public void initLinkList() {
        studentList = new LinkedList<>();
        studentList.add(new Student(1001, "qdm1", 20));
        studentList.add(new Student(1002, "qdm2", 25));
        studentList.add(new Student(1003, "qdm3", 19));
        studentList.add(new Student(1004, "qdm4", 27));
    }



    @Test
    public void peek() {
        System.out.println("studentList.peek = " + studentList.peek());
        System.out.println("studentList.size = " + studentList.size());
    }

    @Test
    public void peekFirst() {
        System.out.println("studentList.peekFirst = " + studentList.peekFirst());
        System.out.println("studentList.size = " + studentList.size());
    }

    @Test
    public void peekLast() {
        System.out.println("studentList.peekLast = " + studentList.peekLast());
        System.out.println("studentList.size = " + studentList.size());
    }







}
