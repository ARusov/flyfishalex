package org.flyfishalex.controller;

import org.flyfishalex.bl.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by arusov on 4/2/2015.
 */
@Controller
public class IndexController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private Environment environment;

    @RequestMapping(value = {"/", "/index"})
    public ModelAndView getIndex() {
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("categories", categoryService.getCategories(0));
        mav.addObject("env",environment.getActiveProfiles()[0]);
        return mav;
    }
}
