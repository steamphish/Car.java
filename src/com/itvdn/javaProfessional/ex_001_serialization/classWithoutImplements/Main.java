package com.itvdn.javaProfessional.ex_001_serialization.classWithoutImplements;

import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // Создаем объект класса файл и указываем файл
        File f = new File("file3");
        Car c = new Car(100, 5000, "BMW", new Engine(1500, "MANN"));
        // При десериализации делается вызов конструктора супер класса,
        // значение на 150 не меняет, можно Machie implements Seriazable сделать
        // c.weight = 150;
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
        // Сериализуем объект Car в байт-код
        oos.writeObject(c);
        oos.flush();
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
        // Десериализуем объект Car с байт-кода
        // При десериализации вызывается конструктор суперкласса
        Car newCar = (Car) ois.readObject();
        ois.close();
        System.out.println(newCar.price + " " + newCar.model + " " + newCar.engine.power + " " + newCar.engine.producer + " " + newCar.weight);
    }
}
