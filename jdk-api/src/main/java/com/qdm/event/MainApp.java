package com.qdm.event;

/**
 * @author qiudm
 * @date 2019/1/10 10:06
 * @desc
 */
public class MainApp {


    public static void main(String[] args) {
        EventSourceObject source = new EventSourceObject();
        source.addStateChangeListener(new StateChangeListener());
        source.addStateChangeToOneListener(new StateChangeToOneListener());

        source.changeFlag();
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
//        source.changeFlag();
//        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
//        source.changeFlag();
    }

}
