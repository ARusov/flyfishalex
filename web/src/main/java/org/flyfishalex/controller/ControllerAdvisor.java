package org.flyfishalex.controller;

import org.flyfishalex.controller.exception.UserNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(UserNotFoundException.class)
    public String handle(UserNotFoundException ex) {

        return "redirect:"+ex.getLang().getContext()+"/user/login";
    }
}