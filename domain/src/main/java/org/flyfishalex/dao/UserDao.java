package org.flyfishalex.dao;

import org.flyfishalex.enums.Lang;
import org.flyfishalex.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

/**
 * Created by arusov on 14.05.2015.
 */
@Repository
public class UserDao {
    private static final String SEQ_KEY = "user";

    @Autowired
    private MongoOperations operations;

    @Autowired
    private SequenceDAO sequenceDAO;

    public static String cryptWithMD5(String pass) {
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

    public void createUser(User user) {
        if (user != null) {
            user.setPwd(cryptWithMD5(user.getPwd()));
            user.setId(sequenceDAO.getNextSequenceId(SEQ_KEY));
            operations.save(user);
        }
    }

    public void saveUser(User user) {
        if (user != null) {
            operations.save(user);
        }
    }

    public void updateUser(User user) {
        if (user != null) {
            user.setPwd(cryptWithMD5(user.getPwd()));
            operations.save(user);
        }
    }

    public User getUser(String email, Lang lang) {
        Query query = query(where("email").is(email).and("lang").is(lang.getLang()));
        return operations.findOne(query, User.class);
    }

    public User getUser(long id) {
        Query query = query(where("id").is(id));
        return operations.findOne(query, User.class);
    }


    public User getUser(String email, String pwd, Lang lang) {
        Query query = query(where("email").is(email)
                .and("pwd").is(cryptWithMD5(pwd))
                .and("lang").is(lang.getLang()));
        return operations.findOne(query, User.class);
    }

    public List<User> getUsers() {
        Query query = new Query();
        query.with(new Sort(Sort.Direction.ASC, "id"));
        return operations.find(query, User.class);
    }
}
