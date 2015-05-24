package org.flyfishalex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/{lang}")
public class ContactController {

    @RequestMapping(value = "/feedback")
    public ModelAndView getFeedback(@PathVariable("lang") String lang){
        ModelAndView mav= new ModelAndView("feedback");
        mav.addObject("lang", lang);
        return mav;
    }
}
