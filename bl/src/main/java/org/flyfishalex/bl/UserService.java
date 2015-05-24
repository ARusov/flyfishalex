package org.flyfishalex.bl;

import org.flyfishalex.dao.UserDao;
import org.flyfishalex.exception.UserException;
import org.flyfishalex.model.User;
import org.springframework.beans.factory.annotation.Autowired;
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
        User checkUser=userDao.getByEmail(user.getEmail());
        if (checkUser!=null){
            throw new UserException("User exists");
        }
        userDao.createUser(user);
    }

    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    public User getCurrentUser() {
        return null;
    }

    public User getUser(String email, String pwd) {
        return userDao.getUser(email,pwd);
    }
    public UserDetails loadUserByUsername(String email){
        return userDao.loadUserByUsername(email);
    }
}
