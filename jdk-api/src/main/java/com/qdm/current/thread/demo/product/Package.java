package com.qdm.current.thread.demo.product;

import com.alibaba.fastjson.JSON;
import com.qdm.current.thread.data.Apple;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qiudm
 * @date 2018/12/24 10:39
 * @desc
 */
public class Package {

    private List<Apple> appleList = new ArrayList<>();

    public void add(Apple apple)  {
        System.out.println("add apple = " + JSON.toJSONString(apple) + ", size=" + getSize());
        appleList.add(apple);
    }

    public void remove()  {
        if (appleList.size() > 0) {
            Apple apple = appleList.get(0);
            System.out.println("remove apple = " + JSON.toJSONString(apple)+ ", size=" + getSize());
            appleList.remove(apple);
        }
    }

    public int getSize() {
        return appleList.size();
    }

}
