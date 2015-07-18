package org.flyfishalex.controller;

import org.flyfishalex.enums.Lang;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SuccessController extends AbstractController {


    @RequestMapping(value = "/{lang}/user/order/success", method = RequestMethod.GET)
    public ModelAndView getOrderSuccess(@PathVariable("lang") String lang){
        ModelAndView mav= new ModelAndView("orderSuccess");
        mav.addObject("lang", Lang.getLang(lang));
        return mav;
    }
    @RequestMapping(value = "/{lang}/user/registration/success", method = RequestMethod.GET)
    public ModelAndView getRegistrationSuccess(@PathVariable("lang") String lang){
        ModelAndView mav= new ModelAndView("registrationSuccess");
        mav.addObject("lang", Lang.getLang(lang));
        return mav;
    }
}
