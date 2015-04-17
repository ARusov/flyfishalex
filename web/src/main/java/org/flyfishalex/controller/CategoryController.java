package org.flyfishalex.controller;

import org.flyfishalex.bl.CategoryService;
import org.flyfishalex.bl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by arusov on 4/2/2015.
 */
@Controller
@RequestMapping(value = "/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    @Autowired
    private Environment environment;

    @RequestMapping(value = "/{id}")
    public ModelAndView getCategories(@PathVariable("id") long categoryId) {
        ModelAndView mav = new ModelAndView("category");
        mav.addObject("categories", categoryService.getCategories(categoryId));
        mav.addObject("rootCategory", categoryService.getCategory(categoryId));
        mav.addObject("products", productService.getProducts(categoryId));
        mav.addObject("path", categoryService.getCategoriesForPath(categoryId));
        mav.addObject("env",environment.getActiveProfiles()[0]);
        return mav;
    }


}
