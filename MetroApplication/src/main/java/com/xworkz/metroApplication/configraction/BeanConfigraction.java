package com.xworkz.metroApplication.configraction;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import lombok.extern.slf4j.Slf4j;

@Configuration
@ComponentScan("com.xworkz.metroApplication")
@Slf4j
public class BeanConfigraction {

	 public BeanConfigraction() {
	log.info("invoking in the BeanConfigraction.....");
	}
	 
	 @Bean
	 ViewResolver resolver(){
		 log.info("invoking in the Viewresolver method....");
		 ViewResolver resolver=new InternalResourceViewResolver("/",".jsp");
		return resolver;
		 }
	 
	 @Bean
	 LocalContainerEntityManagerFactoryBean getEntity() {
		return new LocalContainerEntityManagerFactoryBean();
		 
	 }
}
