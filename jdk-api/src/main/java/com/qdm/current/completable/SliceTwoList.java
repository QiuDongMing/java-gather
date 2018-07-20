package com.qdm.current.completable;

import com.google.common.collect.Lists;
import com.qdm.current.completable.data.Animal;
import com.qdm.current.completable.data.User;

import java.util.List;
import java.util.function.Supplier;

/**
 * @author qiudm
 * @date 2018/7/3 15:53
 * @desc
 */
public class SliceTwoList {

    Supplier firstPart; // 集合一计算器
    Supplier secondPart; // 集合二计算器

    private static List<User> users = Lists.newArrayList(
            new User("1001", "张一", 11),
            new User("1002", "张二", 12),
            new User("1003", "张三", 13),
            new User("1004", "张四", 14)
    );

    private static List<Animal> animals = Lists.newArrayList(
            new Animal("12001", "Animal张一", "color1"),
            new Animal("12002", "Animal张二", "color2"),
            new Animal("12003", "Animal张三", "color3"),
            new Animal("12004", "Animal张四", "color4")
    );


}
