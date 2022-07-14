package com.itvdn.javaProfessional.ex_002_XML.XMLParser;

import java.io.*;

public class XMLParser {

    private String xml;

    public XMLParser(String path) {
        byte[] buf = null;

        try {
            // RandomAccessFile, конструктор принимает 2 параметра, путь и имя файлового потока
            RandomAccessFile file = new RandomAccessFile(path, "r");
            try {
                buf = new byte[(int) file.length()];
                file.read(buf);
            } finally {
                file.close();
            }
        } catch (IOException ex) {
        }

        try {
            xml = new String(buf, "US-ASCII");
        } catch (UnsupportedEncodingException ex) {
        }
    }

    // Метод определения "catalog/book/author"
    public String get(String path) {
        // Разбиваем /
        String[] parts = path.split("/");
        String s_xml = xml;

        for (String s : parts) {
            String toFind = "<" + s + ">";
            // start начинается с 1 символа найденного тега
            int start = s_xml.indexOf(toFind);
            if (start < 0)
                return null;
            else
                start += toFind.length();

            // Находим закрывающийся тег
            int end = s_xml.lastIndexOf("</" + s + ">");
            if (end < 0)
                return null;

            // Вырезаем найденную строку
            s_xml = s_xml.substring(start, end);
        }

        return s_xml;
    }
}
