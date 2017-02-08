package com.aelbardai.medidoc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.aelbardai.medidoc.beans.User;
import com.aelbardai.medidoc.beans.UserProfile;
import com.aelbardai.medidoc.service.UserProfileService;
import com.aelbardai.medidoc.service.UserService;

@Controller
@RequestMapping("/")
@SessionAttributes("roles")
public class HelloWorldController {
    
    @Autowired
    PersistentTokenBasedRememberMeServices persistentTokenBasedRememberMeServices;
     
    @Autowired
    AuthenticationTrustResolver authenticationTrustResolver;
    
    @Autowired
    UserProfileService userProfileService;
    
    @Autowired
    UserService userService;
    
    
    
    @RequestMapping(value = "/" ,method = RequestMethod.GET)
    public String sayHello(ModelMap model) {
        model.addAttribute("greeting", "Hello World from Spring 4 MVC");
        return "layout/meta";
    }
 
    @RequestMapping(value = "/helloagain", method = RequestMethod.GET)
    public String sayHelloAgain(ModelMap model) {
        model.addAttribute("greeting", "Hello World Again, from Spring 4 MVC");
        return "layout/meta";
    }
    
    @RequestMapping("/Access_Denied")
    public String accessDenied(){
        return "admin/access_denied";
    }
    
    @RequestMapping("/login")
    public String loginForm(){
        if (isCurrentAuthenticationAnonymous()) {
            return "profile/signin";
        } else {
            return "redirect:/";  
        }
    }
    
    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){    
            //new SecurityContextLogoutHandler().logout(request, response, auth);
            persistentTokenBasedRememberMeServices.logout(request, response, auth);
            SecurityContextHolder.getContext().setAuthentication(null);
        }
        return "redirect:/login?logout";
    }
    
    @RequestMapping("/signup")
    public String signupForm(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("roles" , userProfileService.findAll());
        return "profile/signup";
    }
    
    @RequestMapping(value= "/signup" , method= RequestMethod.POST)
    public String signup(User user , BindingResult result){
        if(userService.isUserUsernameUnique(user.getId(), user.getUsername())){
            userService.saveUser(user);
        }
        else{
            return "profile/signup";
        }
        return "redirect:/";
    }
    
    
    
    
    private boolean isCurrentAuthenticationAnonymous() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authenticationTrustResolver.isAnonymous(authentication);
    }
    

}
