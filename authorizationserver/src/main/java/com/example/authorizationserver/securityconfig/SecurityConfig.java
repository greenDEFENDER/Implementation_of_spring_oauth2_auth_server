package com.example.authorizationserver.securityconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.authorizationserver.repo.Repo;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	// securing all endpoints
	@Bean
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
		return http.authorizeRequests(authorizeRequests -> authorizeRequests.anyRequest().authenticated()).formLogin()
				.and().build();
	}

	// loading user info
	@Bean
	UserDetailsService userDetailsService(Repo userRepo) {
		return username -> userRepo.findUser(username);
	}

	// declaring password encoder
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
