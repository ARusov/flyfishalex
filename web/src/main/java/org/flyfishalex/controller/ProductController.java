package org.flyfishalex.controller;

import org.flyfishalex.bl.CategoryService;
import org.flyfishalex.bl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by arusov on 4/2/2015.
 */
@Controller
public class ProductController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private Environment environment;

    @Autowired
    private ProductService productService;


    @RequestMapping(value ="/product/{productId}")
    public ModelAndView getIndex() {
        ModelAndView mav = new ModelAndView("product");
        mav.addObject("categories", categoryService.getCategories(0));
        mav.addObject("env",environment.getActiveProfiles()[0]);
        return mav;
    }
}
