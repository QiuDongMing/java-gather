package com.qdm.classloder;

import org.junit.Test;

/**
 * @author qiudm
 * @date 2019/2/27 10:36
 * @desc
 */
public class ConstantPoolTests {

   public final String A = "a";


    @Test
    public void stringTest1() {
        String c = "ab";
        String a1 = "a";
        String b1 = "b";

        final String b2 = "b";

        String d1 = a1 + b1;
        String d2 = a1 + b2;
        System.out.println("c = " + c);
        System.out.println("d1 = " + d1);
        System.out.println("d2 = " + d2);
        System.out.println("c==d " + (c == d1));
        System.out.println("c==d " + (c == d2));
    }


    @Test
    public void stringTest2() {
        String a = "hello2";
        final String b = "hello";
        String d = "hello";
        String c = b + 2;
        String e = d + 2;
        System.out.println((a == c));
        System.out.println((a == e));
    }




}
