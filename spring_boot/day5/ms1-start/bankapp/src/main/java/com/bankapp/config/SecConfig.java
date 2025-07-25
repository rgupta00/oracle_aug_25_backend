package com.bankapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity //to enable customization of spring sec ...
public class SecConfig {
	
	//authenticate, what are the user and what are there password
	@Bean
	public UserDetailsService detailsService() {
		UserDetails raj=User.withUsername("raj").password("raj123").roles("ADMIN").build();
		UserDetails ekta=User.withUsername("ekta").password("ekta123").roles("MGR").build();
		UserDetails gun=User.withUsername("gun").password("gun123").roles("CLERK").build();
		return new InMemoryUserDetailsManager(raj, ekta, gun);
	}
	//raj any url
	//ekta except admin
	//gun clerk
	
	//authorized
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
		return httpSecurity.csrf(AbstractHttpConfigurer::disable)
			.cors(AbstractHttpConfigurer::disable)
			.authorizeHttpRequests(reg-> reg.requestMatchers("/admin/**").hasAnyRole("ADMIN")
					.requestMatchers("/mgr/**").hasAnyRole("ADMIN","MGR")
					.requestMatchers("/clerk/**").hasAnyRole("CLERK","ADMIN","MGR")
					.requestMatchers("/home/**").permitAll()
					.anyRequest().authenticated())
			.httpBasic(Customizer.withDefaults())
			.sessionManagement(con->con.sessionCreationPolicy(SessionCreationPolicy.STATELESS)).build();
		
	}
	
	
	//password encoder
	
	@Bean	//hey spring sec dont exp password encoding ... hello world
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

}
