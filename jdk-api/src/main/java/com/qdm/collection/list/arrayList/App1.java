package com.qdm.collection.list.arrayList;

import com.google.common.collect.Lists;
import com.qdm.data.po.Student;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qiudm
 * @date 2018/7/3 16:39
 * @desc
 */
public class App1 {

    private static final int INTERVAL = 2;


    @Test
    public void setStudentPos() {

        int pageIndex = 4;
        int pageSize = 15;


        List<Student> students = queryStudent(pageIndex, pageSize);


        int lisiPageSize = pageSize / INTERVAL + pageIndex % INTERVAL;

        List<Student> studentsPos = queryStudentLisi(pageIndex, lisiPageSize);
//        for (Student s : studentsPos) {
//            System.out.println("studentsPos = " + s);
//        }


        List<Student> studentNews = Lists.newArrayList();
        int newStuPosSize = studentsPos.size();
        int newPosIndex = 0;
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            studentNews.add(student);
            if ((i + pageIndex * pageSize   + 1) % INTERVAL == 0 && newPosIndex <= newStuPosSize - 1) {
                Student studentPos = studentsPos.get(newPosIndex);
                studentNews.add(studentPos);
                newPosIndex++;
            }
        }

        int index = 0;
        for (Student s : studentNews) {
            index++;
            System.out.println(index + ", s = " + s);
        }

    }


    @Test
    public void testGetAdPageSize() {

        int interval = 2;
//        for (int j = interval; j < 5; j++) {
//            for (int i = 1; i < 30; i++) {
//                int adPageSize = getAdPageSize(i, j);
//                System.out.println("pageSize=" + i + ",interval=" + j + ",adPageSize =" + adPageSize);
//            }
//        }
    }





    private List<Student> queryStudentLisi(int pageIndex, int pageSize){

        List<Student> allStudentLisi = Lists.newArrayList();

        for(int i=1;i<1000;i++) {
            Student s = new Student( i, "lisi" + i, 10);
            allStudentLisi.add(s);
        }

        return allStudentLisi.subList(pageIndex * pageSize, pageSize * pageIndex + pageSize);
    }




    private List<Student> queryStudent(int pageIndex, int pageSize){

        List<Student> allStudent = Lists.newArrayList();

        for(int i=1;i<1000;i++) {
            Student s = new Student(1000 + i, "zhangsan" + i, 10);
            allStudent.add(s);
        }

        return allStudent.subList(pageIndex * pageSize, pageSize * pageIndex + pageSize);
    }



    private int getStudentLisiPageSize(int pageIndex, int pageSize) {


        return 0;
    }





}
