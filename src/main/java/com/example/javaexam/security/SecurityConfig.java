package com.example.javaexam.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authManager(
            HttpSecurity security,
            BCryptPasswordEncoder encoder,
            UserDetailsService userDetailsService)
            throws Exception {
        System.err.println("AuthManager");

        return security
                .getSharedObject
                        (AuthenticationManagerBuilder.class)
                .userDetailsService(userDetailsService)
                .passwordEncoder(encoder).
                and().build();

    }

     @Bean
    public SecurityFilterChain filterChain(HttpSecurity security) throws Exception {
        security
                .authorizeRequests()
                .anyRequest()
                .permitAll()
                /*.antMatchers("/clients")
                .authenticated()
                .antMatchers("/users",
                                    "/countries",
                                    "/clientsUpdate")
                .hasAuthority(ADMIN.name())
                .mvcMatchers("/rest/addNewClient").authenticated()*/
                .and()
                .formLogin().
                loginPage("/authorization")
                .and().logout().
                logoutSuccessUrl("/authorization");
        return security.build();
    }
}
