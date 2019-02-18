package com.coderme.design.observer.jdk;

/**
 * @author qiudm
 * @date 2019/2/18 13:48
 * @desc
 */
public class WorkInfo {

    private String name;


    public WorkInfo(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "WorkInfo{" +
                "name='" + name + '\'' +
                '}';
    }
}
