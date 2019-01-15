package com.qdm.collection.maps;

import org.junit.Test;

import java.util.*;

/**
 * @author qiudm
 * @date 2019/1/11 10:16
 * @desc
 */
public class MapTests {

    @Test
    public void mapMethods() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);

        final Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println("key = " + entry.getKey() + ", val=" + entry.getValue());
        }


//        map.remove("a");
//        Collection<Integer> values = map.values();
//        Iterator<Integer> iterator = values.iterator();
//        while (iterator.hasNext()) {
//            System.out.println("values = " + iterator.next());
//        }
//
//        values.forEach(System.out::println);



    }


    @Test
    public void hashCodeTest() {
        Integer a = 10;
        String b = "10";
        String c = new String("10");
        String d = "10";
        System.out.println("a.hashCode() = " + a.hashCode());
        System.out.println("b.hashCode() = " + b.hashCode());
        System.out.println("c.hashCode() = " + c.hashCode());
        System.out.println("b == c :" + (b == c));
        System.out.println("b == d :" + (b == d));
        System.out.println("c == d :" + (c == d));

        String str = "ab";//97 98
        System.out.println("str = " + str.hashCode());  //98 + 31*97

    }

    public void ClassArr() {
        MyClass[] myClasses = new MyClass[2];

    }





}

class MyClass {

}
