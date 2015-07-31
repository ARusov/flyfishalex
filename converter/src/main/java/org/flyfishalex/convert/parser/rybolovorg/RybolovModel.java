package org.flyfishalex.convert.parser.rybolovorg;

import javax.xml.bind.annotation.*;

/**
 * Created by arusov on 3/27/2015.
 */
@XmlRootElement(name = "offer")
@XmlAccessorType(XmlAccessType.FIELD)
public class RybolovModel {

    @XmlAttribute(name = "id")
    private int id;

    @XmlElement(name = "categoryId")
    private int categoryId;

    @XmlElement(name = "price")
    private int price;

    @XmlElement(name = "name")
    private String name;

    @XmlElement(name = "picture")
    private String picture;

    @XmlElement(name = "model")
    private String model;

    public RybolovModel() {
    }


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
