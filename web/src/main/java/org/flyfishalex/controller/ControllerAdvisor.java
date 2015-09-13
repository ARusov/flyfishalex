package org.flyfishalex.controller;

import org.flyfishalex.controller.exception.UserNotFoundException;
import org.flyfishalex.exception.UserException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(UserNotFoundException.class)
    public String handle(UserNotFoundException ex) {
        return "redirect:"+ex.getLang().getContext()+"/user/login";
    }
}