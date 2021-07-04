package com.qdm.datastruct.util;

import java.util.List;

public class PrintUtil {




    public static void printList(List<?> list) {
        for (Object o : list) {
            System.out.print(o + " ");
        }
        System.out.println();
        System.out.println("==============================");
    }



}
