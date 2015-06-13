package org.flyfishalex.dao;

import org.flyfishalex.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

/**
 * Created by arusov on 14.05.2015.
 */
@Repository
public class UserDao implements UserDetailsService {
    private static final String SEQ_KEY = "user";

    @Autowired
    private MongoOperations operations;

    @Autowired
    private SequenceDAO sequenceDAO;




    public void createUser(User user) {
        if (user != null) {
            user.setPwd(cryptWithMD5(user.getPwd()));
            user.setId(sequenceDAO.getNextSequenceId(SEQ_KEY));
            operations.save(user);
        }
    }

    public void updateUser(User user) {
        if (user != null) {
            user.setPwd(cryptWithMD5(user.getPwd()));
            operations.save(user);
        }
    }

    public User getUser(String email) {
        Query query = query(where("email").is(email));
        return operations.findOne(query, User.class);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = getUser(email);
        if (user == null) {
            throw new UsernameNotFoundException("User was not found user email = " + email);
        }
        List<SimpleGrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority(user.getRole()));
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPwd(), authorities);
        return userDetails;
    }

    public User getUser(String email, String pwd) {
        System.out.println(cryptWithMD5(pwd));
        Query query = query(where("email").is(email).and("pwd").is(cryptWithMD5(pwd)));
        return operations.findOne(query, User.class);
    }

    public static String cryptWithMD5(String pass){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] passBytes = pass.getBytes();
            md.reset();
            byte[] digested = md.digest(passBytes);
            StringBuffer sb = new StringBuffer();
            for(int i=0;i<digested.length;i++){
                sb.append(Integer.toHexString(0xff & digested[i]));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException ex) {
        }
        return null;


    }
}
