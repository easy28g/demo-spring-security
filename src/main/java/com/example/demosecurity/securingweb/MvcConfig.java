package com.example.demosecurity.securingweb;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer {

	@Value("${upload.path}")
    private String uploadPath;

	public void addViewControllers(ViewControllerRegistry registry) {
		// registry.addViewController("/home").setViewName("home");
		// registry.addViewController("/").setViewName("home");
		// registry.addViewController("/hello").setViewName("hello");
		registry.addViewController("/login").setViewName("login");
	}

	public void addResourceHandlers(ResourceHandlerRegistry registry){
		registry.addResourceHandler("/uploads/**")
				.addResourceLocations("file:" + uploadPath + "/");
	}

}