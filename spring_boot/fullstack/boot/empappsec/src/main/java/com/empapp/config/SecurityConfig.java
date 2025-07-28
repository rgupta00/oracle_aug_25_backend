package com.empapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    	http
        .csrf(csrf -> csrf.disable())
        .cors(Customizer.withDefaults()) // 👈 this enables your corsConfigurationSource bean
        .authorizeHttpRequests(auth -> auth
            .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
            .anyRequest().authenticated()
        )
        .httpBasic(Customizer.withDefaults());

    return http.build();
    }

    @Bean
     InMemoryUserDetailsManager userDetailsService() {
        UserDetails user = User
            .withUsername("raj")
            .password("raj123")
            .roles("USER")
            .build();

        return new InMemoryUserDetailsManager(user);
    }

    // Only for testing/demo (use BCryptPasswordEncoder in real apps)
    @Bean
     PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}





