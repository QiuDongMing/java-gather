package com.coderme.design.strategy.headfirst;

/**
 *
 */
public abstract class Duck {

    /**
     * 飞行行为
     */
    FlyBehavior flyBehavior;

    /**
     * 叫声行为
     */
    QuackBehavior quackBehavior;

    void performFly() {
        flyBehavior.fly();
    }

    void performQuack() {
        quackBehavior.quack();
    }

    public abstract void display();

    void swim() {
        System.out.println("所有鸭子有的游泳行为");
    }



}
