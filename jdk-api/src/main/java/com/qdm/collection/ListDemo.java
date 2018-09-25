package com.qdm.collection;

import com.google.common.collect.Lists;
import com.qdm.data.po.Student;
import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author qiudm
 * @date 2018/4/10 16:23
 * @desc
 */
public class ListDemo {

    @Test
    public void isNullList() {
        List<Student> studentList = Lists.newArrayList();
        System.out.println("Objects.isNull(studentList) = " + Objects.isNull(studentList));
        System.out.println("Collections = " + CollectionUtils.isEmpty(studentList));
    }

    @Test
    public void subList() {

        List<Student> students = new ArrayList<Student>() {
            {
                add(new Student(1001, "zhangsan1", 76));
                add(new Student(1002, "zhangsan2", 78));
                add(new Student(1003, "zhangsan3", 75));
                add(new Student(1004, "zhangsan4", 85));
                add(new Student(1005, "zhangsan5", 86));
                add(new Student(1006, "zhangsan6", 66));
                add(new Student(1007, "zhangsan7", 77));
                add(new Student(1008, "zhangsan88", 88));
                add(new Student(1009, "zhangsan9", 99));
            }
        };
        int pageSize = 2;

        List<Student> students1 = students.subList(0, 2);
        List<Student> students2 = students.subList(2, 4);
        List<Student> students3 = students.subList(6, 8);
        System.out.println("students1 = " + students1);
        System.out.println("students2 = " + students2);
        System.out.println("students3 = " + students3);


    }

    @Test
    public void listDistict() {

        List<Student> students = new ArrayList<Student>() {
            {
                add(new Student(1001, "zhangsan1", 76));
                add(new Student(1001, "zhangsan1", 79));
                add(new Student(1002, "zhangsan2", 78));
                add(new Student(1003, "zhangsan3", 75));
                add(new Student(1004, "zhangsan4", 85));
                add(new Student(1005, "zhangsan5", 86));
                add(new Student(1006, "zhangsan6", 66));
                add(new Student(1007, "zhangsan7", 77));
                add(new Student(1009, "zhangsan9", 99));
                add(new Student(1009, "zhangsan9", 98));
                add(new Student(1008, "zhangsan88", 88));

            }
        };

        ArrayList<Student> collect = students.stream().collect(//list是需要去重的list，返回值是去重后的list
                Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(o -> o.getId()))),
                        ArrayList::new));

        for (Student s: collect) {
            System.out.println("s = " + s);
        }

    }





}
