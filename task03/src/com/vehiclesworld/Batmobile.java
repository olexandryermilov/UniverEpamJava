package com.vehiclesworld;

public class Batmobile extends CVehicle implements Flyable,Moveable,Swimable {
    public Batmobile(int cost, int speed, int year) {
        super(cost, speed, year);
    }

    @Override
    public int fly() {
        return getSpeed();
    }

    @Override
    public int move() {
        return getSpeed();
    }

    @Override
    public int swim() {
        return getSpeed();
    }
}
