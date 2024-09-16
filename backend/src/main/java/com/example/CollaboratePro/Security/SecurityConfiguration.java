package com.example.CollaboratePro.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.example.CollaboratePro.Servicio.UsuarioServicio;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    private final UsuarioServicio usuarioServicio;

    public SecurityConfiguration(UsuarioServicio usuarioServicio) {
        this.usuarioServicio = usuarioServicio;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @SuppressWarnings("deprecation")
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(authorizeRequests
                        -> authorizeRequests
                        .requestMatchers("/registro/**", "/js/**", "/css/**", "/img/**").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(formLogin
                        -> formLogin
                        .loginPage("/login")
                        .permitAll()
                )
                .logout(logout
                        -> logout
                        .invalidateHttpSession(true)
                        .clearAuthentication(true)
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                        .logoutSuccessUrl("/login?logout")
                        .permitAll()
                );

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder =
                new AuthenticationManagerBuilder((ObjectPostProcessor<Object>) http.getSharedObject(AuthenticationConfiguration.class));
        authenticationManagerBuilder.userDetailsService(usuarioServicio)
                .passwordEncoder(passwordEncoder());
        return authenticationManagerBuilder.build();
    }
}