package com.eric.spring.config;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * 取代以前的XML,改以JAVA的POJO來做Spring環境的設定
 * @author yung.ho
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.eric.spring")
public class AppConfig {
	
	@Bean
	public PropertyPlaceholderConfigurer configProperties() {
		PropertyPlaceholderConfigurer configurer = new PropertyPlaceholderConfigurer();
		configurer.setSystemPropertiesMode(PropertyPlaceholderConfigurer.SYSTEM_PROPERTIES_MODE_OVERRIDE);
		return configurer;
	}
}
