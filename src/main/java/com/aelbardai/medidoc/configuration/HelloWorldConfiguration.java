package com.aelbardai.medidoc.configuration;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@Import(JPAConfiguration.class)
@EnableWebMvc
@ComponentScan(basePackages = {"com.aelbardai.medidoc.controller" , 
		"com.aelbardai.medidoc.service" , 
		"com.aelbardai.medidoc.dao"})
public class HelloWorldConfiguration extends WebMvcConfigurerAdapter{
	
    @Bean
    public MultipartResolver multipartResolver() {
        return new StandardServletMultipartResolver();
    }


	/*@Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/jsp/");
        viewResolver.setSuffix(".jsp");
 
        return viewResolver;
    }*/
	
    @Bean
    public MessageSource messageSource() {
    	System.out.println("from the message ressources");
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("content.Language");
        return messageSource;
    }
    
   /* @Bean(name = "localeResolver")
    public LocaleResolver localeResolver(){
	CookieLocaleResolver resolver = new CookieLocaleResolver();
	resolver.setDefaultLocale(new Locale("ar_MA"));
	resolver.setCookieName("myLocaleCookie");
	resolver.setCookieMaxAge(4800);
	return resolver;
    }
    
    public void addInterceptors(InterceptorRegistry registry) {
    	   registry.addInterceptor(localeChangeInterceptor());
    	} 
 
    @Bean 
    public LocaleChangeInterceptor localeChangeInterceptor(){
        LocaleChangeInterceptor localeChangeInterceptor=new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName("language");
        return localeChangeInterceptor;
    }*/
 
	
	/*@Bean
    public ReloadableResourceBundleMessageSource messageSource(){
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:content.Language");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }*/

    @Bean
    public CookieLocaleResolver localeResolver(){
        CookieLocaleResolver localeResolver = new CookieLocaleResolver();
        localeResolver.setDefaultLocale(Locale.ENGLISH);
        localeResolver.setCookieName("my-locale-cookie");
        localeResolver.setCookieMaxAge(3600);
        return localeResolver;
    }

    @Bean
    public LocaleChangeInterceptor localeInterceptor(){
        LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
        interceptor.setParamName("language");
        return interceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeInterceptor());
    }

    @Bean
    public InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/jsp/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
  
    
}
