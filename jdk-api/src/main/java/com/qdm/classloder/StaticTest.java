package com.qdm.classloder;

/**
 * @author qiudm
 * @date 2019/2/14 11:05
 * @desc
 * 原文地址：https://blog.csdn.net/justloveyou_/article/details/72466105
 * 根本：实例初始化不一定要在类初始化结束之后才开始初始化
 */
public class StaticTest {

    public static void main(String[] args) {
        System.out.println(" = 1");
        staticFunction();
        System.out.println(" = 2");
    }

    static StaticTest st = new StaticTest();

    static {   //静态代码块
        System.out.println("1");
    }

    {       // 实例代码块
        System.out.println("2");
    }

    StaticTest() {    // 实例构造器
        System.out.println("3");
        System.out.println("a=" + a + ",b=" + b);
    }

    public static void staticFunction() {   // 静态方法
        System.out.println("4");
    }

    int a = 110;    // 实例变量
    static int b = 112;     // 静态变量
}
