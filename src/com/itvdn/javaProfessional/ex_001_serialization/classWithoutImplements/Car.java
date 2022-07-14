package com.itvdn.javaProfessional.ex_001_serialization.classWithoutImplements;

import java.io.*;

public class Car extends Machine implements Serializable {
    int price;
    String model;
    transient Engine engine;

    Car(int weight, int price, String model, Engine engine) {
        super(weight);
        this.price = price;
        this.model = model;
        this.engine = engine;
    }

    private void writeObject(ObjectOutputStream oos) {
        try {
            System.out.println("-------->>>>>>WRITE");
            // Все что можно записываем обычным способом
            oos.defaultWriteObject();
            // То что нормально записать не можем, то записываем напрямую через метод
            oos.writeInt(engine.power);
            oos.writeObject(engine.producer);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private void readObject(ObjectInputStream ois) {
        try {
            System.out.println("-------->>>>>>READ");
            // Все что можно считываем обычным способом
            ois.defaultReadObject();
            // То что записать не можем нормально, то записываем через метод writeInt()
            this.engine = new Engine(ois.readInt(), (String) ois.readObject());

        } catch (IOException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class Engine implements Serializable {
    int power;
    String producer;

    Engine(int power, String producer) {
        this.power = power;
        this.producer = producer;
    }
}

class Machine implements Serializable {
    // int weight = 100;
    int weight;

    Machine() {

    }

    Machine(int weight) {
        this.weight = weight;
    }
}