package com.itvdn.javaProfessional.ex_003_JAXB.JAXB;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@XmlRootElement(name = "shop")
public class Shop {

    // Список книг и при помощи аннотации будет сгенерирован элемен book
    @XmlElement(name = "album")
    private List<Album> albums = new ArrayList<>();

    public void add(Album album) {
        albums.add(album);
    }

    @Override
    public String toString() {
        return Arrays.deepToString(albums.toArray());
    }
}

