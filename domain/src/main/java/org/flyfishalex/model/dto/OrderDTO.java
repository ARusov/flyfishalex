package org.flyfishalex.model.dto;

import org.flyfishalex.model.OrderPoint;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arusov on 02.06.2015.
 */
public class OrderDTO {

    private List<OrderPoint> orderPoints= new ArrayList<OrderPoint>();

    public OrderDTO() {
    }

    public List<OrderPoint> getOrderPoints() {
        return orderPoints;
    }

    public void setOrderPoints(List<OrderPoint> orderPoints) {
        this.orderPoints = orderPoints;
    }
}
