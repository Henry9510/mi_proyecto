package com.example.CollaboratePro.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/", "/login").permitAll() // Permitir acceso a la página de inicio y login
                .anyRequest().authenticated() // Requiere autenticación para cualquier otra solicitud
            )
            .formLogin(formLogin -> 
                formLogin
                    .loginPage("/login") // Página de inicio de sesión personalizada
                    .permitAll() // Permitir acceso a la página de login
            )
            .logout(logout -> 
                logout
                    .permitAll() // Permitir acceso al cierre de sesión
            )
            .csrf(csrf -> csrf.disable()); // Desactivar CSRF para simplificar (sólo en casos de prueba o APIs REST)
        
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Codificador de contraseñas BCrypt
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        return new InMemoryUserDetailsManager(
            org.springframework.security.core.userdetails.User.withUsername("user")
                .password(passwordEncoder().encode("password"))
                .roles("USER")
                .build(),
            org.springframework.security.core.userdetails.User.withUsername("admin")
                .password(passwordEncoder().encode("admin"))
                .roles("USER", "ADMIN")
                .build()
        );
    }
}
