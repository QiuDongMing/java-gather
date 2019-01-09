package com.qdm.symbol;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

/**
 * @author qiudm
 * @date 2019/1/7 10:00
 * @desc
 */
public class SymbolTest1 {

    /**
     * int a = 10;
     * +10的原码是00001010,那他的反码,补码都和原码相同 也是00001010,原因是正数的原 反 补码相同
     * -10的原码是10001010,那他的反码是11110101,也就是符号位不变,其他位0变1,1变0. 他的补码是在反码的基础上,最低位加1,也就是11110110
     */

    /**
     *
     * java中的最大整数值
     * 32位
     * 2^31 - 1 = 2147483647 01111111 11111111 11111111 11111111
     * 一个Int类型数据占据空间4字节。每个字节8位，共32位。因此最大存储2的31次方（从2的0次方开始）。
     * 但32位的第一位是符号位。所以2的31次方减1.简单说Int类型占据4字节，所以是这个取值范围。
     *
     * java中的最小整数值
     * -2^31 = -2147483648   10000000 00000000 00000000 00000000
     *
     */
    @Test
    public void javaMaxInteger () {
        int maxInteger = Integer.MAX_VALUE;
        System.out.println("maxInteger = " + maxInteger);
        System.out.println("      maxInteger.toBinaryString = " + Integer.toBinaryString(maxInteger));
        System.out.println("      maxInteger.toBinaryString.length = " + Integer.toBinaryString(maxInteger).length());

        System.out.println("maxInteger + 1 = " + (maxInteger + 1));
        System.out.println("(maxInteger + 1).toBinaryString = " + Integer.toBinaryString(maxInteger + 1));
        System.out.println("(maxInteger + 1).toBinaryString.length = " + Integer.toBinaryString(maxInteger + 1).length());
    }




    /**
     * >>
     * 有符号右移位，将运算数的二进制整体右移指定位数，整数高位用0补齐，负数高位用1补齐（保持负数符号不变）
     */
    @Test
    public void symbolTest1() {
        int a = 9;
        System.out.println("十进制 = " + a + ", 二进制 = " + Integer.toBinaryString(a));
        int b = 9 >> 1;
        System.out.println("右移一位:");
        System.out.println("十进制 = " + b + ", 二进制 = " + Integer.toBinaryString(b));
    }


    /**
     * <<
     * 有符号左移位，将运算数的二进制整体左移指定位数，低位用0补齐。
     */
    @Test
    public void symbolTest2() {
        int a = -10;
        System.out.println("十进制 = " + a + ", 二进制 = " + Integer.toBinaryString(a));
        int b = a << 2;
        System.out.println("左移二位:");
        System.out.println("十进制 = " + b + ", 二进制 = " + Integer.toBinaryString(b));
    }


    /**
     * 数字右移1位后的值(结论是 偶数减半， 奇数-1 后减半) int res = num % 2 ==0 ? num / 2 : (num-1) / 2    num = 0 => res=0
     */
    @Test
    public void getNumRightValue() {
        for (int i = 0; i<29; i ++) {
            System.out.println("i = " + i + ", 右移1位后的值：" + (i>>1));
        }
    }


}
