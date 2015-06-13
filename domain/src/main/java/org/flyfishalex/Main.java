package org.flyfishalex;

import org.flyfishalex.dao.CategoryDao;
import org.flyfishalex.dao.OrderDao;
import org.flyfishalex.dao.ProductDao;
import org.flyfishalex.model.Category;
import org.flyfishalex.model.Delivery;
import org.flyfishalex.model.Product;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by arusov on 4/1/2015.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        OrderDao orderDao = (OrderDao) context.getBean("orderDao");
        Delivery delivery= new Delivery();
        delivery.setDescription("Почта России");
        orderDao.saveDelivery(delivery);

    }
}
