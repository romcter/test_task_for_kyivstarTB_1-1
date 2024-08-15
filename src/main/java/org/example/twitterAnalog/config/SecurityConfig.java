package org.example.twitterAnalog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .cors(Customizer.withDefaults ())
                .authorizeHttpRequests()
                .requestMatchers(
                        AntPathRequestMatcher
                                .antMatcher("/users/register"),
                        AntPathRequestMatcher
                                .antMatcher("/users/{username}"),
                        AntPathRequestMatcher
                                .antMatcher("/swagger-ui/**"),
                        AntPathRequestMatcher
                                .antMatcher("/api-docs/**")
                )
                .permitAll()
                .and()
                .build();

        return http.build();
    }
}
