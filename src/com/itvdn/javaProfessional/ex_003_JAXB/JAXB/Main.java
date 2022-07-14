package com.itvdn.javaProfessional.ex_003_JAXB.JAXB;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        Shop catal = new Shop();
        catal.add(new Album("Author1", "Title1", 40.55, new Date()));
        catal.add(new Album("Author2", "Title2", 30, new Date()));

        try {
            // Создаем файл
            File file = new File("/Users/vdonets/Downloads/007_Serialization_XML_and_JSON/007_Samples/src/com/itvdn/javaProfessional/ex_003_JAXB/JAXB/output.xml");
            // Вызываем статический метод JAXBContext
            JAXBContext jaxbContext = JAXBContext.newInstance(Shop.class);
            // Возвращает объект класса Marshaller, для того чтобы трансформировать объект
            Marshaller mar = jaxbContext.createMarshaller();

            // Читабельное форматирование
            mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            // Записываем в файл, marshal(из памяти, в файл)
            mar.marshal(catal, file);
            mar.marshal(catal, System.out); //на консоль

            // Считываем из файла
            Unmarshaller unmar = jaxbContext.createUnmarshaller();
            catal = (Shop) unmar.unmarshal(file);
            System.out.println(catal);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}