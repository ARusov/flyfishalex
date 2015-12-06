package org.flyfishalex.controller;

import org.flyfishalex.bl.CategoryService;
import org.flyfishalex.controller.exception.UserNotFoundException;
import org.flyfishalex.enums.Lang;
import org.flyfishalex.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ControllerAdvisor {

    @Autowired
    private CategoryService categoryService;

    @ExceptionHandler(UserNotFoundException.class)
    public ModelAndView handle(UserNotFoundException ex) {
        Lang lang= ex.getLang();
        ModelAndView mav = new ModelAndView(lang.getLang()+"/login");
        mav.addObject("user", new User());
        mav.addObject("lang", lang);
        mav.addObject("rootCategories", categoryService.getCategoriesDTO(0, ex.getLang()));
        mav.addObject("childCategories", categoryService.get2ndCategories(ex.getLang()));
        return mav;
    }
}