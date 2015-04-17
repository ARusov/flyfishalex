package org.flyfishalex.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by arusov on 4/1/2015.
 */
@Document(collection = "category")
public class Category {

    @Id
    private long id;


    private String name;

    private String nameEn;

    private boolean isRU;

    private boolean isEN;

    private long parentId;

    private String articul1c;

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public boolean isRU() {
        return isRU;
    }

    public void setRU(boolean isRU) {
        this.isRU = isRU;
    }

    public boolean isEN() {
        return isEN;
    }

    public void setEN(boolean isEN) {
        this.isEN = isEN;
    }

    public String getArticul1c() {
        return articul1c;
    }

    public void setArticul1c(String articul1c) {
        this.articul1c = articul1c;
    }

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}