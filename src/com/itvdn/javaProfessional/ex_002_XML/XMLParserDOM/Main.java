package com.itvdn.javaProfessional.ex_002_XML.XMLParserDOM;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("/Users/vdonets/Downloads/007_Serialization_XML_and_JSON/007_Samples/src/com/itvdn/javaProfessional/ex_002_XML/XMLParserDOM/1.xml");

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            // Получаем объект DocumentBuilder
            DocumentBuilder db = dbf.newDocumentBuilder();

            // Парсим объект DocumentBuilder и получаем объект Document
            Document doc = db.parse(xmlFile);

            // Возвращает объект класса Element, получаем корневой элемент
            Element root = doc.getDocumentElement();
            System.out.println("Корневой элемент: " + root.getNodeName());
            System.out.println("----------------------");

            // Для корневого элемента вызываем метод getChildNodes
            NodeList nl = root.getChildNodes();

            for (int i = 0; i < nl.getLength(); i++) {
                // По номеру получаем узел
                Node node = nl.item(i);
                // Проверяем определенный тип, если узел является элементом, то входим в тело
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    System.out.println("Book:");
                    System.out.println("Author: " + element.getElementsByTagName("author").item(0).getChildNodes().item(0).getNodeValue());
                    System.out.println("Title: " + element.getElementsByTagName("title").item(0).getChildNodes().item(0).getNodeValue());
                    System.out.println("----------------------");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}