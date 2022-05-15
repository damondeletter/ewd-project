package com.springBoot.fifa;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//PasswordEncoder encoder =  
               // PasswordEncoderFactories.createDelegatingPasswordEncoder();
        auth.inMemoryAuthentication()
          .withUser("user").password(passwordEncoder().encode("user")).roles("USER").and()
          .withUser("admin").password(passwordEncoder().encode("admin")).roles("USER","ADMIN");
    }
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
		 http.formLogin().
         defaultSuccessUrl("/", true).
         loginPage("/login");
		 
		 http.authorizeRequests()
		 .antMatchers("/fifa").hasRole("USER")
		 .antMatchers("/fifa/*").hasRole("ADMIN").and().csrf();
    }
}
