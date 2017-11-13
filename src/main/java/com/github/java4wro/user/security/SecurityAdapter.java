package com.github.java4wro.user.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityAdapter extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();

        http.authorizeRequests()
                .antMatchers("/api/users").authenticated()
                .anyRequest().permitAll();


        http.formLogin()
                .loginPage("/api/users/login")
                .usernameParameter("user")
                .passwordParameter("password")
                .defaultSuccessUrl("/hello.html")
                .failureHandler((request, response, exception) -> response.sendError(HttpStatus.BAD_REQUEST.value(), "Username or password invalid"));
    }

    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }

}