package org.flyfishalex.dao;

import org.flyfishalex.enums.Lang;
import org.flyfishalex.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

;

/**
 * Created by arusov on 4/1/2015.
 */

@Repository
public class CategoryDao {

    private static final String SEQ_KEY = "category";

    @Autowired
    private MongoOperations operations;

    @Autowired
    private SequenceDAO sequenceDAO;


    public void createCategory(Category category) {
        if (category != null) {
            if (category.getId() <= 0) {
                category.setId(sequenceDAO.getNextSequenceId(SEQ_KEY));
            }
            operations.save(category);
        }
    }

    public Category getCategory(long id) {
        Query query = query(where("id").is(id));
        return operations.findOne(query, Category.class);
    }

    public List<Category> getAll() {
        return operations.findAll(Category.class);
    }


    public List<Category> getCategories(long parentId, Lang lang) {
        Query query = query(where("parentId").is(parentId).and("stores").is(lang.getId()));
        query.with(new Sort(Sort.Direction.ASC,"id"));
        return operations.find(query, Category.class);
    }


    public List<Category> getCategories() {

        return operations.findAll(Category.class);

    }

    public void save(Category category) {
        if (category != null) {
            operations.save(category);
        }
    }

    public void delete(Category category) {
        if (category != null) {
            operations.remove(category);
        }

    }

    public List<Category> getCategories(Lang lang) {
        Query query = query(where("stores").is(lang.getId()));
        query.with(new Sort(Sort.Direction.ASC, "name"));
        return operations.find(query, Category.class);
    }

    public List<Category> getParentCategories(long categoryId, Lang lang) {
        List<Category> categories = new ArrayList<Category>();
        Category category = getCategory(categoryId, lang);
        if (category != null) {
            if (category.getParentId() > 0) {
                categories.add(0, category);
            }
            long parentId = category.getParentId();
            while (parentId > 0) {
                category = getCategory(parentId, lang);
                if (category != null) {
                    if (category.getParentId() > 0) {
                        categories.add(0, category);
                    }
                    parentId = category.getParentId();
                } else {
                    break;
                }
            }
        }
        return categories;
    }

    private Category getCategory(long categoryId, Lang lang) {
        Query query = query(where("id").is(categoryId).and("stores").is(lang.getId()));
        return operations.findOne(query, Category.class);
    }

    public Category getByVendorParentId(String vendorParentId) {
        Query query = query(where("vendorId").is(vendorParentId));
        return operations.findOne(query, Category.class);
    }

    public List<Category> get2ndCategories(Lang lang) {
        List<Category> categories = new ArrayList<Category>();
        List<Category> parents = getCategories(0, lang);
        for (Category parent : parents) {
            Query query = query(where("parentId").is(parent.getId()).and("stores").is(lang.getId()));
            categories.addAll((List<Category>) operations.find(query, Category.class));
        }


        return categories;
    }

    public Category getCategory(String categoryName) {
        Query query = query(where("name").is(categoryName));
        return operations.findOne(query, Category.class);
    }
}
