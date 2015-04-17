package org.flyfishalex.bl;

import org.flyfishalex.dao.CategoryDao;
import org.flyfishalex.dao.ProductDao;
import org.flyfishalex.model.Category;
import org.flyfishalex.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arusov on 4/2/2015.
 */
@Service
public class ProductService {

    @Autowired
    private ProductDao productDao;

    public List<Product> getProducts(long categoryId){
        List<Product> products=productDao.getProducts(categoryId);
        return products;
    }
}
