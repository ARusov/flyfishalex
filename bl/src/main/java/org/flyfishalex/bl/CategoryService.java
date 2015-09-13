package org.flyfishalex.bl;

import org.flyfishalex.dao.CategoryDao;
import org.flyfishalex.model.Category;
import org.flyfishalex.enums.Lang;
import org.flyfishalex.model.dto.CategoryDTO;
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

    public List<CategoryDTO> getCategoriesDTO(long parentId, Lang lang) {
        List<Category> categories = categoryDao.getCategories(parentId, lang);

        return convertCategories(categories,lang);
    }

    public List<Category> getCategories(long parentId, Lang lang) {
        return categoryDao.getCategories(parentId, lang);
    }

    private CategoryDTO convertCategory(Category category, Lang lang) {
        CategoryDTO categoryDTO = new CategoryDTO();
        if (category != null) {
            categoryDTO.setId(String.valueOf(category.getId()));

            if (lang==Lang.EN){
                categoryDTO.setText(category.getNameEn());
            }else {
                    categoryDTO.setText(category.getName());
            }
            categoryDTO.setParent(String.valueOf(category.getParentId()));
        }
        return categoryDTO;
    }

    private List<CategoryDTO> convertCategories(List<Category> categories, Lang lang){
        List<CategoryDTO> categoriesDTO = new ArrayList<CategoryDTO>();
        if(categories!=null){
            for(Category category: categories){
                CategoryDTO categoryDTO=convertCategory(category,lang);
                categoriesDTO.add(categoryDTO);
            }
        }
        return  categoriesDTO;
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

    public CategoryDTO getCategory(long categoryId, String lang) {
        return convertCategory(categoryDao.getCategory(categoryId), Lang.getLang(lang));
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

    public List<Category> getCategories(Lang lang) {
        return categoryDao.getCategories(lang);
    }

    public List<CategoryDTO> getParentCategories(long categoryId, Lang lang) {
        List<Category> categories=categoryDao.getParentCategories(categoryId,lang);
        if(categories!=null){
               if(categories.size()<=0){
                   return null;
               }
        }
        return convertCategories(categories, lang);
    }

    public Category getByVendorParentId(String vendorParentId) {
      return   categoryDao.getByVendorParentId(vendorParentId);
    }

    public  List<CategoryDTO> get2ndCategories(Lang lang) {
        List<Category> categories = categoryDao.get2ndCategories(lang);
        return convertCategories(categories,lang);
    }
}
