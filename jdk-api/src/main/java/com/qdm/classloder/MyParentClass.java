package com.qdm.classloder;

/**
 * @author qiudm
 * @date 2019/2/14 10:51
 * @desc
 */
public class MyParentClass {

    static {
        System.out.println(" static area of MyParentClass " );
    }

    public MyParentClass() {
        System.out.println(" construction MyParentClass " );
    }


}
