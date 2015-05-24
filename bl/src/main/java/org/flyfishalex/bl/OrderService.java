package org.flyfishalex.bl;

import org.flyfishalex.dao.OrderDao;
import org.flyfishalex.model.Order;
import org.flyfishalex.model.OrderPoint;
import org.flyfishalex.model.User;
import org.flyfishalex.model.Variant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class OrderService {
    
    @Autowired
    private OrderDao orderDao;

    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;

    public void addToBasket(OrderPoint orderPoint){
        User user=userService.getCurrentUser();
        Order order= orderDao.getBasketOrder(user.getId(),0);
        if (order==null){
            order= new Order();
            order.setUserId(user.getId());
            order.setDate(new Date());
        }
        order.getOrderPoints().add(orderPoint);
        order.setOrderPoints(order.getOrderPoints());
        order.setDate(new Date());
        orderDao.saveOrder(order);

    }

}
