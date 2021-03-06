package org.flyfishalex.bl;

import org.flyfishalex.dao.OrderDao;
import org.flyfishalex.enums.Lang;
import org.flyfishalex.model.*;
import org.flyfishalex.model.dto.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;

    public void addToBasket(Variant variant, User user, Lang lang) {
        Order order = orderDao.getBasketOrder(user.getId(), 0);
        if (order == null) {
            order = new Order();
            order.setStore(lang.getId());
            order.setUserId(user.getId());

        }
        order.setDate(new Date());
        orderDao.saveOrder(order);


        OrderPoint orderPoint = getOrderPoint(variant.getId(), order.getId());
        if (orderPoint == null) {
            orderPoint = new OrderPoint(variant.getId(), 0, variant.getPrice());
            orderPoint.setDescription(variant.getDescription());
            orderPoint.setOrderId(order.getId());
        }
        orderPoint.setCount(orderPoint.getCount() + 1);
        orderPoint.setPrice(variant.getPrice());


        orderDao.saveOrderPoint(orderPoint);

    }

    public Order getBasket(User user) {
        return orderDao.getBasketOrder(user.getId(), 0);
    }

    public List<OrderPoint> getOrderPoints(long basketId) {
        return orderDao.getOrderPoints(basketId);
    }

    public OrderDTO getOrderPointDTO(long basketId) {
        OrderDTO orderPointDTO = new OrderDTO();
        orderPointDTO.setOrderPoints(getOrderPoints(basketId));
        return orderPointDTO;
    }

    public OrderPoint getOrderPoint(long variantId, long orderId) {
        return orderDao.getOrderPoint(variantId, orderId);
    }

    public OrderPoint getOrderPoint(long orderPointId) {
        return orderDao.getOrderPoint(orderPointId);
    }

    public List<Delivery> getDeliveries(String lang) {
        return orderDao.getDeliveries(lang);
    }

    public void saveDelivery(Delivery delivery) {
        orderDao.saveDelivery(delivery);
    }

    public List<Payment> getPayments(String lang) {
        return orderDao.getPayments(lang);
    }

    public void savePayment(Payment payment) {
        orderDao.savePayment(payment);
    }

    public void saveOrder(Order order) {
        orderDao.saveOrder(order);
    }

    public List<Order> getOrders(long userId) {
        return orderDao.getOrders(userId);
    }
    public List<Order> getOrders() {
        return orderDao.getOrders();
    }

    public void saveOrderPoint(OrderPoint orderPoint) {
        orderDao.saveOrderPoint(orderPoint);
    }

    public Order getOrder(long orderId) {
        return orderDao.getOrder(orderId);
    }

    public Order getOrderById(long orderID) {
        return orderDao.getOrderById(orderID);
    }

    public void removeOrderPoint(OrderPoint currentPoint) {
        orderDao.removeOrderPoint(currentPoint);
    }
}
