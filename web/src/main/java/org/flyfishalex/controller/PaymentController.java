package org.flyfishalex.controller;

import org.flyfishalex.enums.Lang;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/{lang}/payment")
public class PaymentController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView getPayment(@PathVariable("lang") String lang) {
        ModelAndView mav = new ModelAndView("payment");
        mav.addObject("lang", Lang.getLang(lang));
        return mav;
    }
}
