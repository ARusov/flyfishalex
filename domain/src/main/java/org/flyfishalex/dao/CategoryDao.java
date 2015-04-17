package org.flyfishalex.dao;

import org.flyfishalex.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
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
public class CategoryDao {

    private static final String SEQ_KEY = "category";

    @Autowired
    private MongoOperations operations;

    @Autowired
    private SequenceDAO sequenceDAO;


    public void createCategory(Category category) {
        if (category != null) {
            category.setId(sequenceDAO.getNextSequenceId(SEQ_KEY));
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


    public List<Category> getCategories(long parentId) {
        Query query = query(where("parentId").is(parentId));
        return operations.find(query, Category.class);
    }

    //TODO
    public List<Category> getCategoriesForPath(long categoryId) {
        return null;
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
        if(category!=null){
            operations.remove(category);
        }

    }
}
