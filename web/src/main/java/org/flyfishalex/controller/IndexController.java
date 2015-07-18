package org.flyfishalex.controller;

import org.flyfishalex.bl.CategoryService;
import org.flyfishalex.controller.exception.UserNotFoundException;
import org.flyfishalex.enums.Lang;
import org.flyfishalex.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/{lang}")
public class IndexController extends AbstractController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private Environment environment;

    @RequestMapping(value = {"/", "/index", ""})
    public ModelAndView getIndex(@PathVariable("lang") String lang) {
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("rootCategories", categoryService.getCategories(0, Lang.getLang(lang)));
        mav.addObject("user", getUser());
        mav.addObject("lang", Lang.getLang(lang));
        if (Lang.RU == Lang.getLang(lang)) {
            mav.addObject("catalogue", "Каталог");
        }else {
            mav.addObject("catalogue", "Catalogue");
        }
        return mav;
    }
}
