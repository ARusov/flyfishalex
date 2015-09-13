package org.flyfishalex.dao;


import org.flyfishalex.model.OrderPoint;
import org.flyfishalex.model.Delivery;
import org.flyfishalex.model.Order;
import org.flyfishalex.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Repository
public class OrderDao {

    private static final String SEQ_KEY = "order";
    private static final String SEQ_KEY_POINT = "orderPoint";

    @Autowired
    private MongoOperations operations;

    @Autowired
    private SequenceDAO sequenceDAO;

    public Order getBasketOrder(long userId, int statusCode) {
        Query query = query(where("userId").is(userId).and("status").is(statusCode));
        return operations.findOne(query, Order.class);
    }

    public void saveOrder(Order order) {
        if (order != null) {
            if (order.getId() <= 0) {
                order.setId(sequenceDAO.getNextSequenceId(SEQ_KEY));
            }
            operations.save(order);
        }
    }

    public void saveOrderPoint(OrderPoint orderPoint) {
        if (orderPoint != null) {
            if (orderPoint.getId() <= 0) {
                orderPoint.setId(sequenceDAO.getNextSequenceId(SEQ_KEY_POINT));
            }
            operations.save(orderPoint);
        }
    }


    public List<OrderPoint> getOrderPoints(long basketId) {
        Query query = query(where("orderId").is(basketId));
        return operations.find(query, OrderPoint.class);
    }

    public OrderPoint getOrderPoint(long variantId, long orderId) {
        Query query = query(where("orderId").is(orderId).and("variantId").is(variantId));
        return operations.findOne(query, OrderPoint.class);
    }

    public OrderPoint getOrderPoint(long orderPointId) {
        Query query = query(where("id").is(orderPointId));
        return operations.findOne(query, OrderPoint.class);
    }


    public void savePayment(Payment payment) {
        if (payment != null) {
            if (payment.getId() <= 0) {
                payment.setId(sequenceDAO.getNextSequenceId(Payment.SEQ_KEY));
            }
            operations.save(payment);
        }
    }

    public void saveDelivery(Delivery delivery) {
        if (delivery != null) {
            if (delivery.getId() <= 0) {
                delivery.setId(sequenceDAO.getNextSequenceId(Delivery.SEQ_KEY));
            }
            operations.save(delivery);
        }
    }

    public List<Delivery> getDeliveries() {
        return operations.findAll(Delivery.class);
    }

    public List<Payment> getPayments() {
        return operations.findAll(Payment.class);
    }

    public List<Order> getOrders(long userId) {
        Query query = query(where("userId").is(userId).and("status").ne(0));
        return operations.find(query, Order.class);
    }

    public List<Order> getOrders() {
        Query query = query(where("status").ne(0));
        return operations.find(query, Order.class);
    }

    public Order getOrder(long orderId) {
        Query query = query(where("id").is(orderId).and("status").is(2));
        return operations.findOne(query, Order.class);
    }
    public Order getOrderById(long orderId) {
        Query query = query(where("id").is(orderId));
        return operations.findOne(query, Order.class);
    }

    public void removeOrderPoint(OrderPoint currentPoint) {
        if(currentPoint!=null){
            operations.remove(currentPoint);
        }
    }
}
