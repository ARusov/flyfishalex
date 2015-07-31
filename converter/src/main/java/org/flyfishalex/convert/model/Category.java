package org.flyfishalex.convert.model;

/**
 * Created by arusov on 2/25/2015.
 */
public class Category {
    private String name;

    private Category parent;


    public Category(String name, Category parent) {
        this.name = name;
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getParent() {
        return parent;
    }

    public void setParent(Category parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        String name = getName();
        Category parent = getParent();
        while (parent != null) {
            name = parent.getName() + "/" + name;
            parent = parent.getParent();
        }
        return name;
    }
}
