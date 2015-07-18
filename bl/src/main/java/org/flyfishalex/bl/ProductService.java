package org.flyfishalex.bl;

import org.flyfishalex.dao.ProductDao;
import org.flyfishalex.enums.Lang;
import org.flyfishalex.model.Product;
import org.flyfishalex.model.Variant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by arusov on 4/2/2015.
 */
@Service
public class ProductService {

    @Autowired
    private ProductDao productDao;

    public List<Product> getProducts(long productId, Lang lang) {
        List<Product> products = productDao.getProducts(productId, lang);
        return products;
    }

    public Product getProduct(long productId) {
        return productDao.getProduct(productId);
    }

    public List<Product> getProducts() {
        return productDao.getProducts();
    }

    public void saveProduct(Product product) {
        productDao.saveProduct(product);
    }

    public void saveVariant(Variant variant) {
        productDao.saveVariant(variant);
    }

    public List<Variant> getVariants(long productId) {
        return productDao.getVariants(productId);
    }


    public Variant getVariant(long variantId) {
        return productDao.getVariant(variantId);
    }
}
