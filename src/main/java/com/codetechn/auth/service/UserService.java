package com.codetechn.auth.service;

import com.codetechn.auth.entity.User;
import com.codetechn.auth.user.UserCrm;

public interface UserService {
   public  void registerUser(UserCrm user);
   User findByemail(String email);
}
