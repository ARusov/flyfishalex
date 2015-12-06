package org.flyfishalex.controller.admin;

import org.flyfishalex.controller.AbstractController;
import org.flyfishalex.enums.Lang;
import org.flyfishalex.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/{lang}/admin")
public class AdminController extends AbstractController {

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public ModelAndView getAdmin(@PathVariable("lang") String lang) {
        checkUser(Lang.getLang(lang));
        ModelAndView mav = new ModelAndView("admin/admin");
        mav.addObject("lang", Lang.getLang(lang));
        return mav;
    }

    @RequestMapping(value = {"/users"}, method = RequestMethod.GET)
    public ModelAndView getUsers(@PathVariable("lang") String lang) {
        checkUser(Lang.getLang(lang));
        ModelAndView mav = new ModelAndView("admin/users");
        mav.addObject("lang", Lang.getLang(lang));
        mav.addObject("users", userService.getUsers());

        return mav;
    }


    @RequestMapping(value = {"/users"}, method = RequestMethod.POST)
    public String doUsers(@PathVariable("lang") String lang,
                          User user) {
        checkUser(Lang.getLang(lang));
        if(user!=null){
            User currentUser=userService.getUser(user.getId());
            if(currentUser!=null){
                currentUser.setRole(user.getRole());
                userService.saveUser(currentUser);
            }
        }

        return "redirect:"+Lang.getLang(lang).getContext()+"/admin/users";
    }
}
