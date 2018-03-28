package com.qdm.lambda;

import com.qdm.lambda.model.Student;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author qiudm
 * @date 2018/3/28 10:32
 * @desc
 */
public class LambdaStream {

    List<Student> students = null;

    /**
     * 初始化学生信息
     */
    @Before
    public void initStudents() {
        students = new ArrayList<Student>() {
            {
                add(new Student(1001, "zhangsan1", 76));
                add(new Student(1002, "zhangsan2", 78));
                add(new Student(1003, "zhangsan3", 75));
                add(new Student(1004, "zhangsan4", 85));
                add(new Student(1005, "zhangsan5", 86));
                add(new Student(1006, "zhangsan6", 66));
                add(new Student(1007, "zhangsan7", 77));
            }
        };
    }

    /**
     * 输出集合中score > 75的学生
     */
    @Test
    public void streamFilterTest() {
        students.stream().filter((s) -> (s.getScore() > 75)).forEach(
                (s) -> System.out.printf("%d,%s,%d \n", s.getId(), s.getName(), s.getScore())
        );
    }


    /**
     * 使用limit限制输出的个数,输出集合中score > 75的学生前两位
     */
    @Test
    public void streamFilterLimitTest() {
        //使用limit限制输出的个数
        students.stream().filter((s) -> (s.getScore() > 75)).limit(2).forEach(
                (s) -> System.out.printf("%d,%s,%d \n", s.getId(), s.getName(), s.getScore())
        );
    }

    /**
     * 对结果排序并放到新的集合中
     */
    @Test
    public void streamFilterSortTest() {
        //将排序后的结果放到list集合中
        List<Student> stuCollect = students
                .stream()
                .sorted((s1, s2) -> (s1.getScore() - s2.getScore()))
                .collect(Collectors.toList());
        stuCollect.forEach((s) -> System.out.printf("%d,%s,%d \n", s.getId(), s.getName(), s.getScore()));
    }


    /**
     * 自定义过滤器输出学生成绩在70-80之间并且学生Id为奇数的学生
     */
    @Test
    public void streamMyFilterTest() {
        //自定义过滤器
        Predicate<Student> filter1 = (s) -> (s.getScore() > 70 && s.getScore() < 80);
        Predicate<Student> filter2 = (s) -> (s.getId() % 2 == 1);
        students.stream().filter(filter1).filter(filter2).forEach(
                (s) -> System.out.printf("%d,%s,%d \n", s.getId(), s.getName(), s.getScore())
        );
    }

    @Test
    public void streamMaxTest(){
        //获取分数最高的学生(同理可以获取分数最低学生)
        Student student = students
                .stream()
                .max((s1, s2) -> (s1.getScore() - s2.getScore()))
                .get();
        System.out.printf("%d,%s,%d \n", student.getId(), student.getName(), student.getScore());
    }



}
