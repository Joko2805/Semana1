package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


//si es una clase de configuracion se usa la notacion configuration
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	//autenticacion
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("alex").password(passwordEncoder().encode("1234")).roles("ADMIN");
		auth.inMemoryAuthentication().withUser("jose").password(passwordEncoder().encode("1234")).roles("USER");
	}

	//restrigir permiso
	@Override
	protected void configure(HttpSecurity http) throws Exception 
	{		
		http.authorizeRequests()
		    .antMatchers("/instructor/listar_public").permitAll()
		    .antMatchers("/instructor/listar_admin").access("hasRole('ADMIN')")
		    .antMatchers("/instructor/listar_user").access("hasRole('USER')");
		
		http.authorizeRequests().and()
			.httpBasic();
		
		http.authorizeRequests().and()
			.csrf().disable();
	}

	
	//Codificar carateres en base 64
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
