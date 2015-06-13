package org.flyfishalex.model.dto;

import org.flyfishalex.model.OrderPoint;

import java.util.List;

/**
 * Created by arusov on 02.06.2015.
 */
public class OrderDTO {

    private long id;

    private String status;

    private List<OrderPoint> orderPoints;

    public List<OrderPoint> getOrderPoints() {
        return orderPoints;
    }

    public void setOrderPoints(List<OrderPoint> orderPoints) {
        this.orderPoints = orderPoints;
    }
}
