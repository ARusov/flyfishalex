package org.flyfishalex.model.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name = "Группа")
@XmlAccessorType(XmlAccessType.FIELD)
public class Category1c implements Serializable {

    @XmlElement(name = "Группы")
    private Categories1c categories;


    public Categories1c getCategories() {
        return categories;
    }

    public void setCategories(Categories1c categories) {
        this.categories = categories;
    }

    @XmlElement(name = "Ид")
    private String id;

    @XmlElement(name = "Наименование")
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
