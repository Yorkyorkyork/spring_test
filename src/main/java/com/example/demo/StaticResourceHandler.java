package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class StaticResourceHandler implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    	registry
        	.addResourceHandler("/fonts/**")
        	.addResourceLocations("classpath:/static/Escape-ME-main/EscapeME_Web/fonts/");
    	
    	registry
          	.addResourceHandler("/**")
          	.addResourceLocations("classpath:/static/Escape-ME-main/EscapeME_Web/Home_Lognin_Signup/");	
        
    	registry
        	.addResourceHandler("/images/**")
        	.addResourceLocations("classpath:/static/Escape-ME-main/EscapeME_Web/images/");
       
    	registry
        	.addResourceHandler("/main/**")
        	.addResourceLocations("classpath:/static/Escape-ME-main/EscapeME_Web/main/");
        
    	registry
    		.addResourceHandler("/tools/**")
        	.addResourceLocations("classpath:/static/Escape-ME-main/EscapeME_Web/tools/");
        
    }
}