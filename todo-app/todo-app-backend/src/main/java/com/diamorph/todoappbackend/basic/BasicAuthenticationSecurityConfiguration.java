//package com.diamorph.todoappbackend.basic;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.web.SecurityFilterChain;
//
////@Configuration
//public class BasicAuthenticationSecurityConfiguration {
//
//    // Filter chain
//    // authenticate all requests
//    // basic authentication
//    // disabling csrf
//    // stateless rest api
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        return http
//            .csrf(AbstractHttpConfigurer::disable)
//            .authorizeHttpRequests(
//                auth -> auth
//                        .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll() // Response to preflight request doesn't pass access control check: No 'Access-Control-Allow-Origin' header is present on the requested resource.
//                        .anyRequest().authenticated()
//            )
//            .httpBasic(Customizer.withDefaults())
//            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//            .build();
//    }
//}
