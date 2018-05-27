package com.coderme.design.strategy.headfirst;

public class MuteQuack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("<<silence>>");
    }
}
