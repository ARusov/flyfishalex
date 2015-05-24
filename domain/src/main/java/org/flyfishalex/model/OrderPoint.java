package org.flyfishalex.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "orderPoint")
public class OrderPoint {

    @Id
    private long id;

    private long variantId;

    private int count;

    private int price;

    public OrderPoint(long id, long variantId, int count, int price ) {
        this.id = id;
        this.variantId = variantId;
        this.count = count;
        this.price=price;
    }


    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getVariantId() {
        return variantId;
    }

    public void setVariantId(long variantId) {
        this.variantId = variantId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
