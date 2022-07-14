package com.itvdn.javaProfessional.ex_003_JAXB.JAXB;

import java.util.Date;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

// Объекты класса Book, будут трансформироватся в xml элементы с названием book
@XmlRootElement(name = "album")
public class Album {
    private String singer;
    private String title;
    private double price;
    private Date publishDate;

    public Album() {
    }

    public Album(String singer, String title, double price, Date publishDate) {
        this.singer = singer;
        this.title = title;
        this.price = price;
        this.publishDate = publishDate;
    }

    @Override
    public String toString() {
        return "[" + singer + ", " + title + ", " + price + ", " + publishDate + "]";
    }

    public Date getPublishDate() {
        return publishDate;
    }

    // Изменили стандартное название на другое
    @XmlElement(name = "publish_date")
    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public double getPrice() {
        return price;
    }

    // Если в аннотации нет поля name, то аннотации будут соответствовать полям класса
    @XmlElement
    public void setPrice(double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    @XmlElement
    public void setTitle(String title) {
        this.title = title;
    }

    public String getSinger() {
        return singer;
    }

    @XmlElement
    public void setSinger(String singer) {
        this.singer = singer;
    }
}

