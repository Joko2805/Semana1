package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


//si es una clase de configuracion se usa la notacion configuration
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetailService;
	
	//autenticacion
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		/*
		auth.inMemoryAuthentication().withUser("alex").password(passwordEncoder().encode("1234")).roles("ADMIN");
		auth.inMemoryAuthentication().withUser("jose").password(passwordEncoder().encode("1234")).roles("USER");
		auth.inMemoryAuthentication().withUser("editor").password(passwordEncoder().encode("editor")).roles("EDITOR");
		auth.inMemoryAuthentication().withUser("writer").password(passwordEncoder().encode("writer")).roles("WRITER");*/
		auth.userDetailsService(userDetailService).passwordEncoder(passwordEncoder());
	}

	//restrigir permiso
	@Override
	protected void configure(HttpSecurity http) throws Exception 
	{		
		http.authorizeRequests()
		    .antMatchers("/instructor/listar_public","/authenticate","/usuarios/registrar").permitAll()
		    .antMatchers("/instructor/listar_admin").hasAuthority("ADMIN")
		    .antMatchers("/instructor/listar_user").hasAuthority("USER")
			.antMatchers(HttpMethod.POST,"/instructor/**").hasAnyAuthority("ADMIN","WRITER")
			.antMatchers(HttpMethod.PUT,"/instructor/**").hasAnyAuthority("ADMIN","EDITOR")
			.antMatchers(HttpMethod.DELETE,"/instructor/**").hasAuthority("ADMIN");
		
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

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}	
	
	
}
