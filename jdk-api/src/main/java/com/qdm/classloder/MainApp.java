package com.qdm.classloder;

/**
 * @author qiudm
 * @date 2019/2/14 9:42
 * @desc
 * 一个Java对象的创建过程往往包括 类初始化 和 类实例化 两个阶段
 */
public class MainApp {


    public static void main(String[] args) {
//        System.out.println(" 载入MyClass ");
//        try {
//            //1、要加载的类的全限命名 2、是否立即初始化类（https://blog.csdn.net/justloveyou_/article/details/72466416），
//            Class<?> aClass = Class.forName("com.qdm.classloder.MyClass", true,
//                    Thread.currentThread().getContextClassLoader());
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        System.out.println(" 载入MyClass结束 ");
    
        MyClass myClass = new MyClass();
    }


}
