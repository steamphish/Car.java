package com.itvdn.javaProfessional.ex_005_SAXParser.SAXParser;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Main {
    public static void main(String[] args) {
        // Имя файла
        final String fileName = "/Users/vdonets/Downloads/007_Serialization_XML_and_JSON/007_Samples/src/com/itvdn/javaProfessional/ex_005_SAXParser/SAXParser/Phonebook.xml";
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            // Здесь мы определили анонимный класс, расширяющий класс DefaultHandler
            DefaultHandler handler = new DefaultHandler() {
                // Поле для указания, что тэг name начался
                boolean name = false;
                boolean email = false;
                boolean telephone = false;

                // Метод вызывается когда SAXParser "натыкается" на начало тэга
                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    // Если тэг имеет имя name, то мы этот момент отмечаем - начался тэг name
                    if (qName.equalsIgnoreCase("name")) {
                        name = true;
                    }
                    if (qName.equalsIgnoreCase("email")) {
                        email = true;
                    }
                    if (qName.equalsIgnoreCase("telephone")) {
                        telephone = true;
                        System.out.println(attributes.getQName(0)+":"+attributes.getValue(0));
                    }
                }

                // Метод вызывается когда SAXParser считывает текст между тэгами
                @Override
                public void characters(char ch[], int start, int length) throws SAXException {
                    // Если перед этим мы отметили, что имя тэга name - значит нам надо текст использовать.
                    if (name) {
                        System.out.println("Name: " + new String(ch, start, length));
                        name = false;
                    }
                    if (email) {
                        System.out.println("Email: " + new String(ch, start, length));
                        email = false;
                    }
                    if (telephone) {
                        System.out.println("Telephone: " + new String(ch, start, length));
                        telephone = false;
                    }
                }
            };
            // Стартуем разбор методом parse, которому передаем наследника от DefaultHandler, который будет вызываться в нужные моменты
            saxParser.parse(fileName, handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
