package com.springsecurity.springsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class configSecurity {

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder){
        // in memoruUserDetailsService
        UserDetails admin = User.withUsername("Admin")
                .password(encoder.encode("admin"))
                .roles("ADMIN", "USER")
                .build();
        UserDetails user = User.withUsername("user")
                .password(encoder.encode("user"))
                .roles( "USER")
                .build();
        return  new InMemoryUserDetailsManager(admin, user);
    }
    @Bean

    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/allUsers/").permitAll()
                        .anyRequest().authenticated()
                )

                .rememberMe(Customizer.withDefaults());

        return http.build();



    }
    // password encoding
    @Bean
    public  PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
