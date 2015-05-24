package org.flyfishalex.model.dto;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "Группы")
@XmlAccessorType(XmlAccessType.FIELD)
public class Categories1c implements Serializable {

    @XmlElement(name = "Группа")
    private List<Category1c> categories = new ArrayList<Category1c>();

    public List<Category1c> getCategories() {
        return categories;
    }

    public void setCategories(List<Category1c> categories) {
        this.categories = categories;
    }
}

