package br.com.whiz.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig{

    private static final String[] PUBLIC_MATCHERS_GET = {
            "/h2-console/**",
            "/funcionarios/**"
    };

    private static final String[] PUBLIC_MATCHERS = {
            "/h2-console/**"
    };

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeRequests()
                .antMatchers(PUBLIC_MATCHERS).permitAll()
                .antMatchers(HttpMethod.GET ,PUBLIC_MATCHERS_GET).permitAll()
                .anyRequest()
                .authenticated();
        return httpSecurity.build();
    }


}
