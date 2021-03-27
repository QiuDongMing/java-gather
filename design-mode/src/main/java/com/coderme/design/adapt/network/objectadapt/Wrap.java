package com.coderme.design.adapt.network.objectadapt;

import com.coderme.design.adapt.network.Source;
import com.coderme.design.adapt.network.Targetable;

/**
 * @author qiudm
 * @date 2018/9/25 17:38
 * @desc
 */
public class Wrap implements Targetable {

    private Source source;

    public Wrap(Source source) {
        this.source = source;

    }

    @Override
    public void method1() {
        source.method1();
    }

    @Override
    public void method2() {
        System.out.println("method2() in Wrap" );
    }
}
