package com.aelbardai.medidoc.dao;

import java.util.List;

import com.aelbardai.medidoc.beans.UserProfile;

public interface UserProfileDao {
    List<UserProfile> findAll();
    
    UserProfile findByType(String type);
     
    UserProfile findById(int id);
}
