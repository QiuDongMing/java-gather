package com.coderme.design.observer.jdk;

/**
 * @author qiudm
 * @date 2019/2/18 11:42
 * @desc
 */
public class MainApp {

    public static void main(String[] args) {

        Teacher teacher = new Teacher();
        Student student1 = new Student("张三");
        Student student2 = new Student("李四");

        teacher.addObserver(student1);
        teacher.addObserver(student2);

        teacher.addHomeWork(new WorkInfo("workInfoName"));
    }

}
