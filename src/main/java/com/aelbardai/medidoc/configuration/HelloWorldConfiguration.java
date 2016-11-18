package com.aelbardai.medidoc.configuration;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
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
public class HelloWorldConfiguration {
	@Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/jsp/");
        viewResolver.setSuffix(".jsp");
 
        return viewResolver;
    }
	
    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("content.Language");
        return messageSource;
    }
    
    @Bean
    public LocaleResolver localeResolver(){
	CookieLocaleResolver resolver = new CookieLocaleResolver();
	resolver.setDefaultLocale(new Locale("en"));
	resolver.setCookieName("myLocaleCookie");
	resolver.setCookieMaxAge(4800);
	return resolver;
    }
 
    public void addInterceptors(InterceptorRegistry registry) {
	LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
	interceptor.setParamName("locale");
	registry.addInterceptor(interceptor);
    }
 
}
