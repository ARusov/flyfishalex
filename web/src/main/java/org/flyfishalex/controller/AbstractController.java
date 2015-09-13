package org.flyfishalex.controller;


import org.flyfishalex.bl.UserService;
import org.flyfishalex.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class AbstractController {

    protected static final String SESSION_USER = "sessionProfile";

    @Autowired
    private UserService userService;

    @Autowired
    protected HttpSession session;

    protected static String cryptWithMD5(String pass) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] passBytes = pass.getBytes();
            md.reset();
            byte[] digested = md.digest(passBytes);
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < digested.length; i++) {
                sb.append(Integer.toHexString(0xff & digested[i]));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException ex) {
        }
        return null;


    }

    protected User getCurrentUser() {
        String email= (String) session.getAttribute(SESSION_USER);
        return userService.getUser(email);
    }
}
