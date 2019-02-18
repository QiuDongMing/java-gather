package com.qdm.innerclass;

/**
 * @author qiudm
 * @date 2019/2/15 15:12
 * @desc
 * 1、成员内部类：成员内部类是最普通的内部类，它的定义为位于另一个类的内部
 * 1）、成员内部类可以无条件访问外部类的所有成员属性和成员方法（包括private成员和静态成员）
 * 2)、当成员内部类拥有和外部类同名的成员变量或者方法时，会发生隐藏现象，即默认情况下访问的是成员内部类的成员。
 *     如果要访问外部类的同名成员，需要以下面的形式进行访问：
 *     外部类.this.成员变量
 *     外部类.this.成员方法
 * 3)、在外部类中如果要访问成员内部类的成员，必须先创建一个成员内部类的对象，再通过指向这个对象的引用来访问：
 *
 *
 */
public class Circle {

    private int radius;

    private static String name = "circle";


   public class Oval {

        private String name = "oval";

        private int f1;

        private int f2;

        public String getCircleName(){
            String circleName = Circle.this.name; //当成员内部类拥有和外部类同名的成员变量或者方法时，会发生隐藏现象
            System.out.println("circleName = " + circleName);
            return circleName;
        }

        public int getCircleRadius() {
            int circleRadius = radius;
            System.out.println("circleRadius = " + circleRadius);
            return circleRadius;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getF1() {
            return f1;
        }

        public void setF1(int f1) {
            this.f1 = f1;
        }

        public int getF2() {
            return f2;
        }

        public void setF2(int f2) {
            this.f2 = f2;
        }
    }


    public String getOvalName() {
        String ovalName = new Oval().name;
        System.out.println("ovalName = " + ovalName);
        return new Oval().name;
    }


    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Circle.name = name;
    }


    public static void main(String[] args) {

        Circle circle = new Circle();
        circle.setRadius(10);
        circle.getOvalName();

        Oval oval = circle.new Oval();
        oval.setName("oval name");
        oval.getCircleName();
        oval.getCircleRadius();
    }

}
