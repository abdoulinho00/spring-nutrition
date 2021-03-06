package com.aelbardai.medidoc.configuration;

import java.util.Properties;

import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
 
/**
 * 
 * @author aelbardai
 *
 */
@Configuration
@EnableTransactionManagement
@PropertySource(value = { "classpath:application.properties" })
public class JPAConfiguration {
 
    @Autowired
    private Environment environment;
    
    /**
     * 
     * @return
     */
    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(new String[] { "com.aelbardai.medidoc.beans" });
        sessionFactory.setHibernateProperties(jpaProperties());
        return sessionFactory;
     }
    
    /**
     * 
     * @return
     */
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
        dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
        dataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
        dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
        return dataSource;
    }
    
    /**
     * 
     * @return
     * @throws NamingException
     */
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws NamingException {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource());
        factoryBean.setPackagesToScan(new String[] { "com.aelbardai.medidoc.beans" });
        factoryBean.setJpaVendorAdapter(jpaVendorAdapter());
        factoryBean.setJpaProperties(jpaProperties());
        return factoryBean;
    }
 
    /*
     * Provider specific adapter.
     */
    /**
     * 
     * @return
     * 
     */
    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        return new HibernateJpaVendorAdapter();
    }
 
    /*
     * Here you can specify any provider specific properties.
     */
    /**
     * 
     * @return
     */
    private Properties jpaProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
        properties.put("hibernate.hbm2ddl.auto", environment.getRequiredProperty("hibernate.hbm2ddl.auto"));
        properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
        properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
        properties.put("connection.CharSet", environment.getRequiredProperty("hibernate.connection.CharSet"));
        properties.put("connection.useUnicode", environment.getRequiredProperty("hibernate.connection.useUnicode"));
        properties.put("connection.characterEncoding", environment.getRequiredProperty("hibernate.connection.characterEncoding"));
        properties.put("hibernate.use_sql_comments", environment.getRequiredProperty("hibernate.use_sql_comments"));
        return properties;
    }
    
    /**
     * 
     * @param emf
     * @return
     */
    @Bean
    @Autowired
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(emf);
        return txManager;
    }
 
}