package com.qdm.collection;

import com.google.common.collect.Lists;
import com.qdm.data.po.Student;
import org.junit.Test;

import java.util.List;
import java.util.Objects;

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
    }





}
