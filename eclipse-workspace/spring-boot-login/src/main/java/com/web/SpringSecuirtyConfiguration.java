package com.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.web.service.security.UserSpringSecuirtyAuthProvider;


@Configuration //it is java based configuration
@EnableWebSecurity  //Enable spring security features
@EnableGlobalMethodSecurity(prePostEnabled = true) //We want to apply spring security with annotation
@Import(Swagger2Config.class)// this we can ignore time being
public class SpringSecuirtyConfiguration extends WebSecurityConfigurerAdapter { 
	
	
	//This service is special service which has logic for authentication & provides
	//role for authorization
   @Autowired	
   private UserSpringSecuirtyAuthProvider userSpringSecurityAuthProvider;
   
   
   @Override
   protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	   //registering special service and password encoder
	   auth.userDetailsService(userSpringSecurityAuthProvider).passwordEncoder(passwordEncoder());
   }
   
   @Bean
   public PasswordEncoder passwordEncoder() {
     return new BCryptPasswordEncoder(12);
   }
 
  @Override 
  protected void configure(HttpSecurity http) throws Exception { 
	  
	  //Hey spring security do not block these static resource
	  String[] staticResources  =  {
		        "/css/**",
		        "/img/**",
		        "/fonts/**",
		        "/scripts/**",
		    };
    
	http.authorizeRequests()//
      .antMatchers("/auth").permitAll()
      .antMatchers(staticResources).permitAll()
      .antMatchers("/signup").permitAll()
      .antMatchers("/admin/**").hasAuthority("ADMIN")
      // Disallow everything else..
      .anyRequest().authenticated();
    http.csrf().disable();
    //for login
    http.formLogin().failureUrl("/auth?error=true")
    .loginPage("/auth")
    //auth , POST
    .defaultSuccessUrl("/signups")
    /*.failureUrl("/corp/auth?error=true")*/
    .and().exceptionHandling()
    .accessDeniedPage("/access/denied")
    .and()
    .logout().logoutUrl("/logout")
    .logoutSuccessUrl("/auth?error=true")
    .invalidateHttpSession(true) 
    .deleteCookies("JSESSIONID");
  } 
  
  @Override
  public void configure(WebSecurity web) throws Exception {
    // Allow swagger to be accessed without authentication
    web.ignoring().antMatchers("/v2/api-docs")//
        .antMatchers("/swagger-resources/**")//
        .antMatchers("/swagger-ui.html")//
        .antMatchers("/configuration/**")//
        .antMatchers("/webjars/**")//
        .antMatchers("/public")
        // Un-secure H2 Database (for testing purposes, H2 console shouldn't be unprotected in production)
        .and()
        .ignoring()
        .antMatchers("/h2-console/**/**");;
  }
  
 
  /*@Bean
  public AuthenticationFailureHandler customAuthenticationFailureHandler() {
      return new LoginFailureUserAuthHandler(springSecurityService);
  }*/
  
}