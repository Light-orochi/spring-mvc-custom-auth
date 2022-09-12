package com.codetechn.auth.dao;

import com.codetechn.auth.entity.User;

public interface UserDao {
    User findByemail(String email);
    public void registerUser(User user);

}
