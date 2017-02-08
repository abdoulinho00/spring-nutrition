package com.aelbardai.medidoc.beans;

public enum UserProfileType {
    USER("USER"),
    DOCTOR("DOCTOR"),
    ADMIN("ADMIN");
     
    String userProfileType;
     
    private UserProfileType(String userProfileType){
        this.userProfileType = userProfileType;
    }
     
    public String getUserProfileType(){
        return userProfileType;
    }
}
