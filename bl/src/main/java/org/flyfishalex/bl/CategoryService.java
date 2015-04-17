package org.flyfishalex.bl;

import org.flyfishalex.dao.CategoryDao;
import org.flyfishalex.model.Category;
import org.flyfishalex.model.dto1c.CategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arusov on 4/2/2015.
 */
@Service
public class CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    public List<Category> getCategories(long parentId) {
        List<Category> categories = new ArrayList<Category>();
        categories = categoryDao.getCategories(parentId);
        return categories;
    }

    public List<CategoryDTO> getCategoriesDTO() {
        List<CategoryDTO> categoriesDTO = new ArrayList<CategoryDTO>();
        List<Category> categories = categoryDao.getCategories();
        if (categories != null) {
            for (Category category : categories) {
                CategoryDTO categoryDTO = new CategoryDTO();

                categoryDTO.setId(String.valueOf(category.getId()));
                categoryDTO.setText(category.getName());

                if (category.getParentId() != 0) {
                    categoryDTO.setParent(String.valueOf(category.getParentId()));
                }
                categoriesDTO.add(categoryDTO);
            }
        }
        return categoriesDTO;
    }


    public List<Category> getCategories() {

        return categoryDao.getCategories();
    }

    public Object getCategoriesForPath(long categoryId) {
        List<Category> categories = new ArrayList<Category>();
        categories = categoryDao.getCategoriesForPath(categoryId);
        return categories;
    }

    public Category getCategory(long categoryId) {
        return categoryDao.getCategory(categoryId);
    }


    public void createCategory(Category category) {

        categoryDao.createCategory(category);
    }

    public void save(Category category) {
        categoryDao.save(category);
    }

    public void delete(Category category) {
        categoryDao.delete(category);
    }
}
