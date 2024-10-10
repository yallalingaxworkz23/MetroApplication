package com.xworkz.metroApplication.configraction;

import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SpringWebInit extends AbstractAnnotationConfigDispatcherServletInitializer implements WebMvcConfigurer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		log.info("invoking in the getRootConfigClasses....");
		System.out.println("invoking in the rootConfigraction...");
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
         log.info("invoking in the getServletConfigClasses...");
		return new Class [] {BeanConfigraction.class};
	}

	@Override
	protected String[] getServletMappings() {
      log.info("invoking in the getServletMapping..");
		return new String[] {"/"};
	}
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		// TODO Auto-generated method stub
		log.info("invoking in the configureDefaultServletHandiling...");
	configurer.enable();
	}

}
