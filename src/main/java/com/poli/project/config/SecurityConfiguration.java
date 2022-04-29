package com.poli.project.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import io.swagger.models.HttpMethod;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Override 
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
  		
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder()); 

	}
	
	@Override 
	protected void configure(HttpSecurity http) throws Exception {
		 http.cors()
		 	.and()
			.csrf().disable() //Cross-Site Request Forgery (falsificación de petición en sitios cruzados) 
			.authorizeRequests()
			.antMatchers("/api/v1/createPoblacion").hasRole("ADMIN")
			.antMatchers("/api/v1/poblacionL").hasRole("ADMIN")
			.antMatchers("/api/v1/updatePoblacion").hasRole("ADMIN")
			.antMatchers("/api/v1/deletePoblacion").hasRole("ADMIN")
			.antMatchers("/api/v1/poblaciones").hasAnyRole("ADMIN", "USER")
			
			.antMatchers("/api/v1/delitoL").hasRole("ADMIN")
			.antMatchers("/api/v1/updateDelito").hasRole("ADMIN")
			.antMatchers("/api/v1/deleteDelito").hasRole("ADMIN")
			.antMatchers("/api/v1/Delitos").hasAnyRole("ADMIN", "USER")
			.antMatchers("/api/v1/delito").hasAnyRole("ADMIN", "USER")
			
			.antMatchers("/api/v1/GrupoArmadoL").hasRole("ADMIN")
			.antMatchers("/api/v1/updateGrupoArmado").hasRole("ADMIN")
			.antMatchers("/api/v1/deleteGrupoArmado").hasRole("ADMIN")
			.antMatchers("/api/v1/GrupoArmado").hasRole("ADMIN")
			.antMatchers("/api/v1/GrupoArmados").hasAnyRole("ADMIN", "USER")
			
			.antMatchers("/api/v1/DelitosPoblaciones").hasAnyRole("ADMIN", "USER")
			
			//auth with HTTP Methods
			/*
			.antMatchers(HttpMethod.GET, "/api/v1/books/**").hasRole("ADMIN")
			.antMatchers(HttpMethod.GET, "/api/v1/books/**").hasRole("USER")
			.antMatchers(HttpMethod.POST, "/api/v1/books/**").hasRole("ADMIN")
			.antMatchers(HttpMethod.PUT, "/api/v1/books/**").hasRole("ADMIN")
			.antMatchers(HttpMethod.DELETE, "/api/v1/books/**").hasRole("ADMIN")
			*/
			.anyRequest().authenticated() //For any other request, you do not need specific role but still need to be authenticated. 
			.and() 
			.formLogin()//authentication method 
			.and() 
			.httpBasic() //authentication method (allow test postman POST,DELETE,PUT) 
			.and() 
			.logout();//http://localhost:8080/login?logout 
	}

	/*
	@Bean
	public PasswordEncoder noPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	*/
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
	
}
