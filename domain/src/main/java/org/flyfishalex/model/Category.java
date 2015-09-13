package org.flyfishalex.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arusov on 4/1/2015.
 */
@Document(collection = "category")
public class Category {

    @Id
    private long id;

    private String name;

    private String nameEn;

    private List<Integer>stores= new ArrayList<Integer>();

    private long parentId;

    private String vendorId;

    public Category() {
    }

    public List<Integer> getStores() {
        return stores;
    }

    public void setStores(List<Integer> stores) {
        this.stores = stores;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }


    public String getVendorId() {
        return vendorId;
    }

    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
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
