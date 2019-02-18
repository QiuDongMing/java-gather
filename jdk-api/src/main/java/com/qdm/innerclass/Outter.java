package com.qdm.innerclass;

/**
 * @author qiudm
 * @date 2019/2/15 15:35
 * @desc
 * 4、静态内部类
 * 静态内部类也是定义在另一个类里面的类，只不过在类的前面多了一个关键字static。
 * 静态内部类是不需要依赖于外部类的，这点和类的静态成员属性有点类似，并且它不能
 * 使用外部类的非static成员变量或者方法，这点很好理解，因为在没有外部类的对象的
 * 情况下，可以创建静态内部类的对象，如果允许访问外部类的非static成员就会产生矛
 * 盾，因为外部类的非static成员必须依附于具体的对象
 *
 *
 *
 */
public class Outter {

    private String name = "outter";

    private static int len = 10;

    static class Inner {

        public String getOutterName () {
            return null;//不能访问外部类的非静态变量和方法
        }

        public int getOutterLen() {
            return len;
        }
    }



}
