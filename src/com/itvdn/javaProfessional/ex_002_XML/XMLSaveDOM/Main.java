package com.itvdn.javaProfessional.ex_002_XML.XMLSaveDOM;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            // Получаем объект DocumentBuilder
            DocumentBuilder db = dbf.newDocumentBuilder();

            // Создаем чистый документ
            Document doc = db.newDocument();

            // Возвращает объект класса Element, создаем каталог
            Element rootElement = doc.createElement("catalog");
            doc.appendChild(rootElement);

            // book1
            Element book1 = doc.createElement("book1");
            // book1 заносим в каталог
            rootElement.appendChild(book1);

            Element author1 = doc.createElement("author");
            author1.setTextContent("Author 1");
            book1.appendChild(author1);

            // book2
            Element book2 = doc.createElement("book2");
            // book2 заносим в каталог
            rootElement.appendChild(book2);

            Element author2 = doc.createElement("author");
            author2.setTextContent("Author 2");
            book2.appendChild(author2);

            // save
            // Трансформеры - берут данные из одного метода, трансформируют по некоторому алгоритму и перекладывают в другой метод
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer t = tf.newTransformer();
            // Похожая иерархия на I/O
            DOMSource source = new DOMSource(doc);
            StreamResult sr = new StreamResult(new File("D:/Course/Java Professional Course/007_Serialization_XML_and_JSON/007_Samples/src/com/itvdn/javaProfessional/ex_002_XML/XMLSaveDOM/2.xml"));

            // Трансформируем из источника в файл
            t.transform(source, sr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}