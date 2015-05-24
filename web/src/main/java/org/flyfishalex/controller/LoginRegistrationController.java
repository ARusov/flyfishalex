package org.flyfishalex.controller;

import org.flyfishalex.bl.UserService;
import org.flyfishalex.enums.Lang;
import org.flyfishalex.enums.Role;
import org.flyfishalex.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by arusov on 14.05.2015.
 */
@Controller
@RequestMapping(value = "/{lang}/user")
public class LoginRegistrationController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    private ModelAndView getRegistration(@PathVariable("lang") String lang) {
        ModelAndView mav = new ModelAndView("registration");
        mav.addObject("user", new User());
        return mav;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registerUser(@PathVariable("lang") String lang, @ModelAttribute("user") User user) {
        if (user != null) {
            user.setRole(Role.USER.getCode());
            userService.createUser(user);
            System.out.println(user.getEmail());
        }

        return "redirect:" + Lang.getLang(lang).getContext();
    }


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    private ModelAndView getLogin(@PathVariable("lang") String lang) {
        ModelAndView mav = new ModelAndView("login");
        mav.addObject("user", new User());
        mav.addObject("context", Lang.getLang(lang).getContext());
        return mav;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    private String login(@PathVariable("lang") String lang, @ModelAttribute("user") User login, HttpServletRequest request) {
        System.out.println(login.getEmail());
        User user = userService.getUser(login.getEmail(), login.getPwd());
        if (user == null) {
            return "redirect:" + Lang.getLang(lang).getContext() + "/user/login?error=1";
        }
        UserDetails userDetails = userService.loadUserByUsername(user.getEmail());
        Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return "redirect:" + Lang.getLang(lang).getContext();
    }
}
