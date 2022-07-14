package com.itvdn.javaProfessional.ex_001_serialization.serializationWithObj;

import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        // Создаем объект класса файл и указываем файл
        File f = new File("/Users/vdonets/Downloads/007_Serialization_XML_and_JSON/007_Samples/src/com/itvdn/javaProfessional/ex_001_serialization/serializationWithObj/file2");
        Car c = new Car(5000, "BMW", new Engine(1500));
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
        // Сериализуем объект Car в байт-код
        oos.writeObject(c);
        oos.flush();
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
        // Десериализуем объект Car с байт-кода
        Car newCar = (Car)ois.readObject();
        ois.close();
        System.out.println(newCar.price + " " + newCar.model + " " + newCar.engine.power);
    }
}
