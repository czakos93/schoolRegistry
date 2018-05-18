package pl.dawidbronczak.spring.schoolRegistry.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
        http
        	.authorizeRequests()
        		.antMatchers("/register").permitAll()
        		.antMatchers("/desktop").permitAll()
        		.anyRequest().authenticated()
        		.and()
        	.formLogin()
        		.loginPage("/login")
        		.permitAll();  
        }
}
