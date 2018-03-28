package com.qdm.lambda.model;

/**
 * @author qiudm
 * @date 2018/3/28 10:33
 * @desc
 */
public class Student {

    private Integer id;

    private String name;

    private Integer score;

    public Student() {
    }

    public Student(Integer id, String name, Integer score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
