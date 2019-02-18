package com.qdm.innerclass;

/**
 * @author qiudm
 * @date 2019/2/15 15:30
 * @desc
 * 2、局部内部类：局部内部类是定义在一个方法或者一个作用域里面的类，它和成员内部类的区别在于局部内部类的访问仅限于方法内或者该作用域内。
 * 1）、局部内部类就像是方法里面的一个局部变量一样，是不能有public、protected、private以及static修饰符的
 *
 */
public class Man {

    class People {

    }

    public People getWomen() {

        class Women extends People {
            String name = "women";
        }

        return new Women();
    }




}
