package com.coderme.design.adapt.network.objectadapt;

import com.coderme.design.adapt.network.Source;

/**
 * @author qiudm
 * @date 2018/9/25 17:39
 * @desc
 */
public class MainApp {

    public static void main(String[] args) {

        Source source = new Source();
        Wrap wrap = new Wrap(source);
        wrap.method1();
        wrap.method2();
    }


}
