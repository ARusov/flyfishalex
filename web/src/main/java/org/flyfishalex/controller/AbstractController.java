package org.flyfishalex.controller;


import org.flyfishalex.bl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

public class AbstractController {

    @Autowired
    private UserService userService;

    protected User getUserDetails() {
        User userDetails = null;
        Object _user = SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        if (_user != null && _user instanceof User) {
            userDetails = (User) _user;

        }
        return userDetails;
    }

    protected boolean checkRole(String role) {
        UserDetails userDetails = getUserDetails();
        if (userDetails == null) {
            return false;
        }

        for (GrantedAuthority authority : userDetails.getAuthorities()) {
            if (authority.getAuthority().equals(role)) {
                return true;
            }
        }
        return false;
    }

    protected org.flyfishalex.model.User getUser(){
       return userService.getCurrentUser();
    }
}
