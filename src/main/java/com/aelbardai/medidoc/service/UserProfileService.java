package com.aelbardai.medidoc.service;

import java.util.List;

import com.aelbardai.medidoc.beans.UserProfile;

public interface UserProfileService {
    UserProfile findById(int id);
    
    UserProfile findByType(String type);
     
    List<UserProfile> findAll();
}
