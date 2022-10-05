package com.example.ssw_e5_rs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    return http.oauth2ResourceServer(
        c -> c.jwt().jwkSetUri("http://localhost:8080/oauth2/jwks")
    ).httpBasic()
        .and()
        .authorizeRequests()
           .mvcMatchers("/test").hasAnyRole("BASIC")
          .anyRequest().access("isAuthenticated() && !hasRole('BASIC')")
        .and().build();
  }

  @Bean
  public UserDetailsService userDetailsService() {
    var u1 = User.withUsername("app1")
        .password(passwordEncoder().encode("12345"))
        .roles("BASIC")
        .build();

    return new InMemoryUserDetailsManager(u1);
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
