package com.codetechn.auth.service;

import com.codetechn.auth.dao.UserDao;
import com.codetechn.auth.entity.User;
import com.codetechn.auth.user.UserCrm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.logging.Logger;


@Service
public class UserServiceImpl implements UserService{
    private Logger logger = Logger.getLogger(getClass().getName());
    @Autowired
    private UserDao userDao;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public void registerUser(UserCrm user) {
       String encodedPassword=passwordEncoder.encode(user.getPassword());
        User currentUser = new User();
        currentUser.setName(user.getName());
        currentUser.setEmail(user.getEmail());
        currentUser.setPassword(encodedPassword);
        currentUser.setNumber(user.getNumber());
        currentUser.setAddress(user.getAddress());

        logger.info("encoced password registration for " + encodedPassword);





        userDao.registerUser(currentUser);
    }

    @Override
    @Transactional
    public User findByemail(String email) {
        return userDao.findByemail(email);
    }
}
