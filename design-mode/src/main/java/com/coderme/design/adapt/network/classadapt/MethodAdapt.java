package com.coderme.design.adapt.network.classadapt;

import com.coderme.design.adapt.network.Source;
import com.coderme.design.adapt.network.Targetable;

/**
 * @author qiudm
 * @date 2018/9/25 17:30
 * @desc
 */
public class MethodAdapt extends Source implements Targetable {

    @Override
    public void method2() {
        System.out.println("method2() in MethodAdapt" );
    }
}
