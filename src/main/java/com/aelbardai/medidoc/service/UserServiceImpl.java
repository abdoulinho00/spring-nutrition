package com.aelbardai.medidoc.service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aelbardai.medidoc.beans.User;
import com.aelbardai.medidoc.beans.UserProfile;
import com.aelbardai.medidoc.dao.UserDao;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{
 
    @Autowired
    private UserDao dao;
    @Autowired
    private UserProfileService userProfileService;
 
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    public User findById(int id) {
        return dao.findById(id);
    }
 
    public User findByUsername(String username) {
        User user = dao.findByUsername(username);
        return user;
    }
 
    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        if(user.getUserProfiles() == null){
            user.setUserProfiles(new HashSet<UserProfile>());
        }
        UserProfile profile = userProfileService.findByType("USER");
        
        user.getUserProfiles().add(profile);
        user.setCreatedAt(new Date());

        dao.save(user);
    }
 
    /*
     * Since the method is running with Transaction, No need to call hibernate update explicitly.
     * Just fetch the entity from db and update it with proper values within transaction.
     * It will be updated in db once transaction ends. 
     */
    public void updateUser(User user) {
        User entity = dao.findById(user.getId());
        if(entity!=null){
            entity.setUsername(user.getUsername());
            if(!user.getPassword().equals(entity.getPassword())){
                entity.setPassword(passwordEncoder.encode(user.getPassword()));
            }
            entity.setFirstname(user.getFirstname());
            entity.setLastname(user.getLastname());
            entity.setEmail(user.getEmail());
            entity.setUserProfiles(user.getUserProfiles());
        }
    }
 
     
    public void deleteUserByUsername(String username) {
        dao.deleteByUsername(username);
    }
 
    public List<User> findAllUsers() {
        return dao.findAllUsers();
    }
 
    public boolean isUserUsernameUnique(Integer id, String username) {
        User user = findByUsername(username);
        return ( user == null || ((id != null) && (user.getId() == id)));
    }


     
}