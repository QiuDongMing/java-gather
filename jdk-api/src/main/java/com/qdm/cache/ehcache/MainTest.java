package com.qdm.cache.ehcache;

import com.alibaba.fastjson.JSON;
import com.qdm.data.po.Student;

import java.util.concurrent.TimeUnit;

/**
 * @author qiudm
 * @date 2019/2/28 11:19
 * @desc
 */
public class MainTest {

    public static void main(String[] args) throws Exception {

        StudentCache studentCache = StudentCache.getInstance();
        Student student = new Student();
        student.setId(1001);
        student.setName("aa");

        StudentCache studentCache2 = StudentCache.getInstance();

        studentCache.put(1001, student );

        Student student1 = studentCache.get(1001);
        Student student11 = studentCache2.get(1001);

        System.out.println("JSON.toJSONString(student1) = " + JSON.toJSONString(student1));
        System.out.println("JSON.toJSONString(student11) = " + JSON.toJSONString(student11));
        TimeUnit.SECONDS.sleep(3);
        System.out.println("JSON.toJSONString(studentCache.get(1001)) = " + JSON.toJSONString(studentCache.get(1001)));
        System.out.println("JSON.toJSONString(studentCache2.get(1001)) = " + JSON.toJSONString(studentCache2.get(1001)));

        TimeUnit.SECONDS.sleep(7);


        Student student2 = studentCache.get(1001);
        Student student22 = studentCache2.get(1001);
        System.out.println("JSON.toJSONString(student2) = " + JSON.toJSONString(student2));
        System.out.println("JSON.toJSONString(student22) = " + JSON.toJSONString(student22));
    }

}
