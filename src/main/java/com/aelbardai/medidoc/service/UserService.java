package com.aelbardai.medidoc.service;

import java.util.List;

import com.aelbardai.medidoc.beans.User;

public interface UserService {
    User findById(int id);
    
    User findByUsername(String sso);
     
    void saveUser(User user);
     
    void updateUser(User user);
     
    void deleteUserByUsername(String sso);
 
    List<User> findAllUsers(); 
     
    boolean isUserUsernameUnique(Integer id, String username);
}
