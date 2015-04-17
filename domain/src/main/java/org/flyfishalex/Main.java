package org.flyfishalex;

import org.flyfishalex.dao.CategoryDao;
import org.flyfishalex.dao.ProductDao;
import org.flyfishalex.model.Category;
import org.flyfishalex.model.Product;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by arusov on 4/1/2015.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        CategoryDao categoryDao = (CategoryDao) context.getBean("categoryDao");
        ProductDao productDao = (ProductDao) context.getBean("productDao");
        Category category = new Category();
//        category.setName("Двуручные удилища");
//        category.setParentId(26);
//        categoryDao.createCategory(category);
//        System.out.println(category.getId());

//        Product product= new Product();
//        product.setCategoryId(22);
//        product.setName("Elk hair caddis");
//        productDao.createProduct(product);

    }
}
