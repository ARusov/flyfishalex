package org.flyfishalex.controller;

import org.flyfishalex.bl.CategoryService;
import org.flyfishalex.bl.ProductService;
import org.flyfishalex.model.Lang;
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
@RequestMapping(value = "/{lang}/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    @Autowired
    private Environment environment;

    @RequestMapping(value = "/{id}")
    public ModelAndView getCategories(@PathVariable("id") long categoryId, @PathVariable("lang") String lang) {
        ModelAndView mav = new ModelAndView("category");
        mav.addObject("categories", categoryService.getCategories(categoryId, lang));
        mav.addObject("rootCategory", categoryService.getCategory(categoryId, lang));
        mav.addObject("products", productService.getProducts(categoryId));
        mav.addObject("env",environment.getActiveProfiles()[0]);
        mav.addObject("lang",lang);
        if (Lang.RU == Lang.getLang(lang)) {
            mav.addObject("catalogue", "Каталог");
        }else {
            mav.addObject("catalogue", "Catalogue");
        }
        return mav;
    }


}
