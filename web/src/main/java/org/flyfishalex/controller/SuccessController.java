package org.flyfishalex.controller;

import org.flyfishalex.bl.CategoryService;
import org.flyfishalex.enums.Lang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SuccessController extends AbstractController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/{lang}/user/order/success", method = RequestMethod.GET)
    public ModelAndView getOrderSuccess(@PathVariable("lang") String lang){
        ModelAndView mav= new ModelAndView(lang+"/orderSuccess");
        mav.addObject("lang", Lang.getLang(lang));
        mav.addObject("rootCategories", categoryService.getCategoriesDTO(0, Lang.getLang(lang)));
        mav.addObject("childCategories", categoryService.get2ndCategories(Lang.getLang(lang)));
        return mav;
    }
    @RequestMapping(value = "/{lang}/user/registration/success", method = RequestMethod.GET)
    public ModelAndView getRegistrationSuccess(@PathVariable("lang") String lang){
        ModelAndView mav= new ModelAndView(lang+"/registrationSuccess");
        mav.addObject("lang", Lang.getLang(lang));
        mav.addObject("rootCategories", categoryService.getCategoriesDTO(0, Lang.getLang(lang)));
        mav.addObject("childCategories", categoryService.get2ndCategories(Lang.getLang(lang)));
        return mav;
    }
}
