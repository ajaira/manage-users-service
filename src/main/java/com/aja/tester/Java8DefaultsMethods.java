package com.aja.tester;

interface Vehicle {

    //onwards Java8
    static void blowHorn() {
        System.out.println("blow horn!!!");
    }

    default void print() {
        System.out.println("I am a vehicle!");
    }
}

interface FourWheeler {

    default void print() {
        System.out.println("I am a four wheeler!");
    }
}


class Car implements Vehicle, FourWheeler {

    public void print() {
        Vehicle.super.print();
        FourWheeler.super.print();
        Vehicle.blowHorn();
        System.out.println("I am a car!");
    }
}
public class Java8DefaultsMethods {

    public static void main(String[] args) {
        Vehicle vehicle = new Car();
        vehicle.print();
    }
}
