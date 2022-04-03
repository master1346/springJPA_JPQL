package com.example.demo.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

     @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
         auth.inMemoryAuthentication()
                 .withUser("user1").password("{noop}1").authorities("WRITE")
                 .and()
                 .withUser("user2").password("{noop}2").authorities("READ")
                 .and()
                 .withUser("user3").password("{noop}3").authorities("DELETE");
     }
    @Override
    protected void configure(HttpSecurity http) throws Exception{
         http.formLogin().and()
                 .authorizeRequests().antMatchers("/").permitAll()
                 .and()
                 .authorizeRequests().anyRequest().authenticated();
    }


}
