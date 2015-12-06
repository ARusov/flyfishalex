package org.flyfishalex.bl;

import org.flyfishalex.dao.UserDao;
import org.flyfishalex.enums.Lang;
import org.flyfishalex.exception.UserException;
import org.flyfishalex.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Created by arusov on 14.05.2015.
 */
@Service
public class UserService {


    @Autowired
    private UserDao userDao;

    public void createUser(User user,Lang lang) {
        User checkUser = userDao.getUser(user.getEmail(), lang);
        if (checkUser != null) {
            throw new UserException("User exists", lang);
        }
        user.setUuid(UUID.randomUUID().toString());
        userDao.createUser(user);
    }

    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    public void saveUser(User user) {
        userDao.saveUser(user);
    }


    public User getUser(String email, String pwd, Lang lang) {
        return userDao.getUser(email, pwd,lang );
    }


    public User getUser(String email, Lang lang) {
        return userDao.getUser(email, lang);
    }

    public User getUser(long id) {
        return userDao.getUser(id);
    }


    public List<User> getUsers() {
        return userDao.getUsers();
    }
}
