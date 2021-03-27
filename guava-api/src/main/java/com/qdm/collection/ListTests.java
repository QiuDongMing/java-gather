package com.qdm.collection;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.junit.Test;

import java.util.List;

/**
 * @author qiudm
 * @date 2018/12/12 10:38
 * @desc
 */
public class ListTests {


    /**
     * 集合类型转换
     */
    @Test
    public void ListTransform() {

        List<Long> longList = Lists.newArrayList(100L, 200L, 300L);

        //1
        List<String> stringList = Lists.transform(longList, new Function<Long, String>() {
            @Override
            public String apply(@NullableDecl Long aLong) {
                return String.valueOf(aLong);
            }
        });

        //2 1->lambda
        List<String> stringList2 = Lists.transform(longList, (a)->String.valueOf(a));

//        stringList.stream().forEach((s)->System.out.print(s + ","));
        stringList2.stream().forEach((s)->System.out.print(s + ","));
    }




}




