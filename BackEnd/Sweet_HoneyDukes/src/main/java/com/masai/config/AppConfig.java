package com.masai.config;

import java.beans.Customizer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class AppConfig {
	
	@Bean
	public SecurityFilterChain anyMethodName(HttpSecurity http) throws Exception{
		http.authorizeHttpRequests(
				auth -> auth.requestMatchers(HttpMethod.POST, "/products").permitAll()
				.anyRequest().authenticated())
		.csrf(c -> c.disable())
		.formLogin(Customizer.withDefaults())
		.httpBasic(Customizer.withDefaults());
		
		return http.build();
	}
	
	//this method is to configure the password encoder
//	@Bean
//	public PasswordEncoder getPasswordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
	
}
