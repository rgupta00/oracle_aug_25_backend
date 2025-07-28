package com.bankapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity // to enable customization of spring sec ...
@EnableMethodSecurity(prePostEnabled = true)
public class SecConfig {

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private JwtAuthFilter authFilter;

	@Bean
	public DaoAuthenticationProvider authenticationProvider(PasswordEncoder passwordEncoder) {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setPasswordEncoder(passwordEncoder);
		authenticationProvider.setUserDetailsService(userDetailsService);
		return authenticationProvider;
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		return httpSecurity.csrf(AbstractHttpConfigurer::disable)
        .cors(AbstractHttpConfigurer::disable)
//        .authorizeHttpRequests(registry -> registry.anyRequest().authenticated())
        .authorizeHttpRequests(auth-> auth.requestMatchers("authenticate").permitAll().anyRequest().authenticated())
        .httpBasic(Customizer.withDefaults())
        .addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class)// hey spring sec i want customise it
        //dont forget to call my filter befdore UsernamePasswordAuthenticationFilter check for security context
        .sessionManagement(httpSecuritySessionManagementConfigurer ->
                httpSecuritySessionManagementConfigurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS)).build();
	}

//	@Bean
//	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
//		return httpSecurity.csrf(AbstractHttpConfigurer::disable)
//			.cors(AbstractHttpConfigurer::disable)
//			.authorizeHttpRequests(reg-> reg.requestMatchers("/admin/**").hasAnyRole("ADMIN")
//					.requestMatchers("/mgr/**").hasAnyRole("ADMIN","MGR")
//					.requestMatchers("/clerk/**").hasAnyRole("CLERK","ADMIN","MGR")
//					.requestMatchers("/home/**").permitAll()
//					.anyRequest().authenticated())
//			.httpBasic(Customizer.withDefaults())
//			.sessionManagement(con->con.sessionCreationPolicy(SessionCreationPolicy.STATELESS)).build();
//		
//	}

	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
	//we configure a bean which can give me AM ?
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config)throws Exception {
        return config.getAuthenticationManager();
    }
	
}
