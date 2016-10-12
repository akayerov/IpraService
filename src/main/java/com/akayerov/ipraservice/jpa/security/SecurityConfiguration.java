package com.akayerov.ipraservice.jpa.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
@Autowired
private FakeUserDetailsService userDetailsService;
@Override
protected void configure(AuthenticationManagerBuilder auth) throws Exception {
   auth.userDetailsService(userDetailsService);
   System.out.println("SecurityConfiguration:configure");
}
@Override
protected void configure(HttpSecurity http) throws Exception {
	System.out.println("SecurityConfiguration:configure 2");
	http.authorizeRequests().anyRequest().fullyAuthenticated();
	http.httpBasic();
	http.csrf().disable();
}
}

/* 12.10.2016 код ниже протестирован и работает!!!
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
   
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		System.out.println("SecurityConfiguration:configure");	
		auth.inMemoryAuthentication().withUser("user").password("password").roles("USER")
				.and().withUser("admin").password("password").roles("USER", "ADMIN");
	}

	// Possibly overridden methods ...
}

*/