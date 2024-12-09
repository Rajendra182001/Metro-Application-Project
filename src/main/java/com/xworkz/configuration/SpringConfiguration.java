package com.xworkz.configuration;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import sun.nio.cs.ext.MacUkraine;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;
import java.io.File;

@Configuration
@ComponentScan("com.xworkz")
@EnableWebMvc
@Slf4j
public class SpringConfiguration {
    public SpringConfiguration() {
        System.out.println("spring configuration");
    }


    @Bean
    public ViewResolver onGetViewResolver(){
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        log.info("This is onGetViewResolver");
        return new InternalResourceViewResolver("/",".jsp");
    }


    @Bean
      public LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean(){
          System.out.println("local Entity container factory bean has been created");
       LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean =new  LocalContainerEntityManagerFactoryBean();
       return localContainerEntityManagerFactoryBean;
      }


      @Bean
      public MultipartResolver multipartResolver(){
        return  new StandardServletMultipartResolver();
      }

}
