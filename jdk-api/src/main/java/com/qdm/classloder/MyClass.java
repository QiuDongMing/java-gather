package com.qdm.classloder;

/**
 * @author qiudm
 * @date 2019/2/14 9:42
 * @desc
 */
public class MyClass extends MyParentClass {

    int a = 1;

    static {
        System.out.println(" static area of MyClass ");
    }



    public MyClass() {
        System.out.println(" construction MyClass " );
        System.out.println("a = " + a);
    }

    {
        System.out.println(" instance area of MyClass ");
        a = 3;
    }

}
