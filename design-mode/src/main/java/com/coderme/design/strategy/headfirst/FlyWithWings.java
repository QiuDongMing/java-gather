package com.coderme.design.strategy.headfirst;

public class FlyWithWings implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("有翅膀飞行");
    }
}
