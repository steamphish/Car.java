package com.itvdn.javaProfessional.ex_001_serialization.serialization;

import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        // Создаем объект класса файл и указываем файл
        File f = new File("/Users/vdonets/Downloads/007_Serialization_XML_and_JSON/007_Samples/src/com/itvdn/javaProfessional/ex_001_serialization/serialization/file1");
        Car c = new Car(5000, "BMW");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
        // Сериализуем объект Car в байт-код
        oos.writeObject(c);
        oos.flush();
        oos.close();
    }
}
