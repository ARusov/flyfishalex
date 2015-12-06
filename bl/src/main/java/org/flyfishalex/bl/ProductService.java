package org.flyfishalex.bl;

import org.flyfishalex.dao.ProductDao;
import org.flyfishalex.enums.Lang;
import org.flyfishalex.model.Category;
import org.flyfishalex.model.Product;
import org.flyfishalex.model.Variant;
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

    @Autowired
    private CategoryService categoryService;


    public List<Product> getProducts(long categoryId, Lang lang) {
        List<Product> products = productDao.getProducts(categoryId, lang);
        return products;
    }

    public Product getProduct(long productId) {
        return productDao.getProduct(productId);
    }

    public List<Product> getProducts() {
        return productDao.getProducts();
    }

    public List<Product> getProducts(int page) {
        return productDao.getProducts(page);
    }

    public List<Product> getProducts(Lang lang) {
        return productDao.getProducts(lang);
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

    public Product getProductByVendor(String article) {
        return productDao.getProductByVendor(article);
    }

    public List<Product> getLastProducts(int count, Lang lang) {
        return productDao.getLastProducts(count, lang);
    }

    public Variant getVariantByVendor(String article) {
        return productDao.getVariantByVendor(article);
    }

    public Product getProduct(String productName) {
        return productDao.getProduct(productName);
    }

    public List<Product> getProductsFromCategories(Lang lang) {
        List<Product> products= new ArrayList<Product>();
        List<Category> categories= categoryService.getCategories(lang);
        for(Category category:categories){
            List<Product> productsCategory=getProducts(category.getId(),lang);
            if(productsCategory!=null && !productsCategory.isEmpty()){
                products.add(productsCategory.get(0));
            }
        }
        return products;
    }
}
