package com.aelbardai.medidoc.configuration;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class HelloWorldInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
 
	
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { HelloWorldConfiguration.class };
    }
  
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }
  
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/"  };
    }
    
	  @Override
	  protected Filter[] getServletFilters() {
		  CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
		    characterEncodingFilter.setEncoding("UTF-8");
		    characterEncodingFilter.setForceEncoding(true);
		    characterEncodingFilter.setForceRequestEncoding(true);
		    characterEncodingFilter.setForceResponseEncoding(true);
	    return new Filter[] {
	    		characterEncodingFilter
	    };
	  }
    
    
}