package org.flyfishalex.controller;

import org.flyfishalex.bl.CategoryService;
import org.flyfishalex.bl.ProductService;
import org.flyfishalex.enums.Lang;
import org.flyfishalex.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by arusov on 4/2/2015.
 */
@Controller
@RequestMapping(value = "/{lang}/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;


    @RequestMapping(value = "/{id}")
    public ModelAndView getCategories(@PathVariable("id") long categoryId, @PathVariable("lang") String lang) {
        ModelAndView mav = new ModelAndView(lang+"/category");
        mav.addObject("rootCategories", categoryService.getCategoriesDTO(0, Lang.getLang(lang)));
        mav.addObject("childCategories", categoryService.get2ndCategories(Lang.getLang(lang)));
        mav.addObject("categories", categoryService.getCategoriesDTO(categoryId, Lang.getLang(lang)));
        mav.addObject("category", categoryService.getCategory(categoryId));
        mav.addObject("products", productService.getProducts(categoryId, Lang.getLang(lang)));
        mav.addObject("lang",Lang.getLang(lang));
        return mav;
    }


}
