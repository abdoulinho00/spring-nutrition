package com.aelbardai.medidoc.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.aelbardai.medidoc.beans.UserProfile;
import com.aelbardai.medidoc.service.UserProfileService;


@Component
public class RoleToUserProfileConverter implements Converter<Object, UserProfile>{

    
    static final Log logger = LogFactory.getLog(RoleToUserProfileConverter.class);
    
    @Autowired
    UserProfileService userProfileService;
 
    /**
     * Gets UserProfile by Id
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    public UserProfile convert(Object element) {
        Integer id = Integer.parseInt((String)element);
        UserProfile profile= userProfileService.findById(id);
        logger.info("Profile : {}" + profile);
        return profile;
    }
}
