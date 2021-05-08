package com.telusko.secureapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.AntPathMatcher;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;

import java.util.ArrayList;
import java.util.List;


@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
	public AuthenticationProvider authProvider()
	{
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		//provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());  //Use this for plain password.
		provider.setPasswordEncoder(new BCryptPasswordEncoder());
		return provider;
	}
	
	
	 
	
	/*
	@Bean
	@Override
	protected UserDetailsService userDetailsService() {
		 
		List<UserDetails>users = new ArrayList<>();
		users.add(User.withDefaultPasswordEncoder().username("mahesh").password("mahesh").roles("USER").build());
		users.add(User.withDefaultPasswordEncoder().username("sumit").password("sumit").roles("ADMIN").build());
		
		return new InMemoryUserDetailsManager(users);
		
	}
	*/
	


	@Override
    protected void configure(HttpSecurity http) throws Exception {
        
		/* http.csrf().disable()
		.authorizeRequests().antMatchers("/login").permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.loginPage("/login").permitAll()
		.and().csrf().ignoringAntMatchers("/h2-console/**")//don't apply CSRF protection to /h2-console
        .and().headers().frameOptions().sameOrigin()
		.and()
		.logout().invalidateHttpSession(true)
		.clearAuthentication(true)
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.logoutSuccessUrl("/logout-success").permitAll();  
		*/
		
		// Original
		
		http.csrf().disable()
		.authorizeRequests().antMatchers("/login").permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.loginPage("/login").permitAll()
		.and().headers().frameOptions().sameOrigin()
		.and()
		.logout().invalidateHttpSession(true)
		.clearAuthentication(true)
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.logoutSuccessUrl("/logout-success").permitAll();  
		
		/*
		http.authorizeRequests()
        .antMatchers("/h2-console/**").authenticated()//     .hasRole("ADMIN")//allow h2 console access to admins only
        .anyRequest().authenticated()//all other urls can be access by any authenticated role
        .and().formLogin()//enable form login instead of basic login
        .and().csrf().ignoringAntMatchers("/h2-console/**")//don't apply CSRF protection to /h2-console
        .and().headers().frameOptions().sameOrigin();//allow use of frame to same origin urls
		*/
		
        
	}   
	
}
