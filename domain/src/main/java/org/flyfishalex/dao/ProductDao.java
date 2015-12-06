package org.flyfishalex.dao;

import com.google.common.collect.Lists;
import org.flyfishalex.enums.Lang;
import org.flyfishalex.model.Product;
import org.flyfishalex.model.Variant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

;

/**
 * Created by arusov on 4/1/2015.
 */

@Repository
public class ProductDao {

    private static final String SEQ_KEY = "product";
    private static final String SEQ_KEY_VARIANT = "variant";

    @Autowired
    private MongoOperations operations;

    @Autowired
    private SequenceDAO sequenceDAO;


    public void saveProduct(Product product) {
        if (product != null) {
            if (product.getId() <= 0) {
                product.setId(sequenceDAO.getNextSequenceId(SEQ_KEY));
            }
            operations.save(product);
        }
    }

    public void saveVariant(Variant variant) {
        if (variant != null) {
            if (variant.getId() <= 0) {
                variant.setId(sequenceDAO.getNextSequenceId(SEQ_KEY_VARIANT));
            }
            operations.save(variant);
        }
    }

    public Product getProduct(long id) {
        Query query = query(where("id").is(id));
        return operations.findOne(query, Product.class);
    }

    public List<Product> getAll() {
        return operations.findAll(Product.class);
    }


    public List<Product> getProducts(long categoryId, Lang lang) {
        Query query = query(where("categoryId").is(categoryId).and("stores").is(lang.getId()));
        query.with(new Sort(Sort.Direction.ASC, "id"));
        return operations.find(query, Product.class);

    }

    public List<Product> getProducts(Lang lang) {
        Query query = query(where("stores").is(lang.getId()));
        return operations.find(query, Product.class);

    }

    public List<Product> getProducts() {
        return operations.findAll(Product.class);
    }

    public List<Product> getProducts(int page) {
        int limit=50;
        Query query = new Query();
        query.limit(limit);
        query.skip(limit*page);
        query.with(new Sort(Sort.Direction.ASC, "id"));
        return operations.find(query, Product.class);
    }

    public List<Variant> getVariants(long productId) {
        Query query = query(where("productId").is(productId));
        return operations.find(query, Variant.class);
    }

    public Variant getVariant(long variantId) {
        Query query = query(where("id").is(variantId));
        return operations.findOne(query, Variant.class);
    }

    public Product getProductByVendor(String article) {
        Query query = query(where("article").is(article));
        return operations.findOne(query, Product.class);
    }

    public List<Product> getLastProducts(int count, Lang lang) {
        Query query = query(where("stores").is(lang.getId()));
        query.limit(count);
        query.with(new Sort(Sort.Direction.DESC, "id"));
        return operations.find(query, Product.class);
    }

    public Variant getVariantByVendor(String article) {
        Query query = query(where("article").is(article));
        return operations.findOne(query, Variant.class);
    }

    public Product getProduct(String productName) {
        Query query = query(where("name").is(productName));
        return operations.findOne(query, Product.class);
    }
}
