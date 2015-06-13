package org.flyfishalex.bl;

import org.flyfishalex.dao.UserDao;
import org.flyfishalex.exception.UserException;
import org.flyfishalex.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

/**
 * Created by arusov on 14.05.2015.
 */
@Service
public class UserService {


    @Autowired
    private UserDao userDao;

    public void createUser(User user) {
        User checkUser = userDao.getUser(user.getEmail());
        if (checkUser != null) {
            throw new UserException("User exists");
        }
        userDao.createUser(user);
    }

    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    public User getCurrentUser() {
        UserDetails userDetails = getUserDetails();
        if (userDetails == null) {
            return null;
        }

        return userDao.getUser(userDetails.getUsername());
    }

    public User getUser(String email, String pwd) {
        return userDao.getUser(email, pwd);
    }

    public UserDetails loadUserByUsername(String email) {
        return userDao.loadUserByUsername(email);
    }

    protected org.springframework.security.core.userdetails.User getUserDetails() {
        org.springframework.security.core.userdetails.User userDetails = null;
        Object _user = SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        if (_user != null && _user instanceof org.springframework.security.core.userdetails.User) {
            userDetails = (org.springframework.security.core.userdetails.User) _user;

        }
        return userDetails;
    }


}
