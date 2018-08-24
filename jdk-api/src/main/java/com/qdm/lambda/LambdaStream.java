package com.qdm.lambda;

import com.google.common.collect.Lists;
import com.qdm.data.po.Student;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author qiudm
 * @date 2018/3/28 10:32
 * @desc
 */
public class LambdaStream {

    List<Student> students = null;
    List<Integer> numbers = null;

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
                add(new Student(1007, "zhangsan77", 77));
            }
        };
    }

    /**
     * 初始化numbers
     */
    @Before
    public void initNumbers() {
        numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
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

    /**
     * 获取分数最高的学生
     */
    @Test
    public void streamMaxTest() {
        //获取分数最高的学生(同理可以获取分数最低学生)
        Student student = students
                .stream()
                .max((s1, s2) -> (s1.getScore() - s2.getScore()))
                .get();
        System.out.printf("%d,%s,%d \n", student.getId(), student.getName(), student.getScore());
    }

    /**
     * 将学生的名字组合成字符串
     * result:studentNames = zhangsan1,zhangsan2,zhangsan3,zhangsan4,zhangsan5,zhangsan6,zhangsan7
     */
    @Test
    public void streamStudentNameToStringTest() {
        String studentNames = students
                .stream()
                .map(Student::getName)
                .collect(Collectors.joining(","));
        System.out.println("studentNames = " + studentNames);
    }

    /**
     * 将学生的名字放入set集合
     * result :zhangsan1,zhangsan3,zhangsan2,zhangsan5,zhangsan4,zhangsan7,zhangsan6,
     */
    @Test
    public void streamStudentNameToSetTest() {
        Set<String> studentSet = students
                .stream()
                .map(Student::getName)
                .collect(Collectors.toSet());
        studentSet.forEach((s)-> System.out.printf(s + ","));
    }

    /**
     * 将学生的名字放入TreeSet集合(有序)
     * result :zhangsan1,zhangsan2,zhangsan3,zhangsan4,zhangsan5,zhangsan6,zhangsan7,
     */
    @Test
    public void streamStudentNameToTreeSetTest() {
        TreeSet<String> studentTreeSet = students
                .stream()
                .map(Student::getName)
                .collect(Collectors.toCollection(TreeSet::new));
        studentTreeSet.forEach((s)-> System.out.printf(s + ","));
    }

    /**
     * 统计numbers数据
     */
    @Test
    public void streamStaticsData() {
        IntSummaryStatistics statics = numbers
                .stream()
                .mapToInt((x) -> x)
                .summaryStatistics();

        System.out.println("List中最大的数字 : " + statics.getMax());
        System.out.println("List中最小的数字 : " + statics.getMin());
        System.out.println("所有数字的总和   : " + statics.getSum());
        System.out.println("所有数字的平均值 : " + statics.getAverage());
    }

    /**
     * 当list转化为map时，作为key的值在list存在多个时，其对应转化为map时的值（v）使用（v1,v2）->v1|v2决定
     */
    @Test
    public void streamStudentNameToMap() {
        Map<Integer, String> collect = students
                .stream()
                .collect(Collectors.toMap(
                        Student::getId, Student::getName, (v1, v2) -> v1)
                );

        collect.forEach((k, v) -> {
            System.out.println("k = " + k + ", v=" + v);
        });

    }

    /**
     * 去重
     */
    @Test
    public void streamDistinct() {
        List<String> strings = Lists.newArrayList("1","2","3","4","2","4");
        List<String> collect = strings.stream().distinct().collect(Collectors.toList());
        collect.forEach(s->System.out.println(s));
    }





















}
