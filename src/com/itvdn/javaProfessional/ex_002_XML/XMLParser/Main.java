package com.itvdn.javaProfessional.ex_002_XML.XMLParser;

import java.lang.reflect.Array;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Считываем файл.xml
        XMLParser xml = new XMLParser("/Users/vdonets/Downloads/007_Serialization_XML_and_JSON/007_Samples/src/com/itvdn/javaProfessional/ex_002_XML/XMLParser/1.xml");
        // Указываем путь, что будем считывать с файла xml
        String value = xml.get("catalog/book/author");
        System.out.println(value);
    }
}
