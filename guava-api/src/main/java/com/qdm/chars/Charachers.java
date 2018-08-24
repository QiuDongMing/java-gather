package com.qdm.chars;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import org.junit.Test;

import java.util.List;

/**
 * @author qiudm
 * @date 2018/8/24 17:56
 * @desc
 */
public class Charachers {

    /**
     * 连接字符
     */
    @Test
    public void joinerTest1() {
        Joiner joiner = Joiner.on(",").skipNulls();
        String joinRes = joiner.join("i", "love", "", "java", null, "me");
        System.out.println("joinRes = " + joinRes);
    }

    /**
     * 字符串拆分
     */
    @Test
    public void SplitterTest1() {
        String str = "   I;love  ;java;;;k k;me;";
        List<String> stringList = Splitter
                .on(";")            //以【;】拆分
                .trimResults()      //移除结果字符串的前导空白和尾部空白
                .omitEmptyStrings() //从结果中自动忽略空字符串
                .splitToList(str);
        System.out.println("stringList = " + stringList);
    }





























}
