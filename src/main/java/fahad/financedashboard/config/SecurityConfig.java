package fahad.financedashboard.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(
            HttpSecurity http
    ) throws Exception {
        return
                http
                        .csrf(csrf -> csrf.disable())
                        .authorizeHttpRequests(auth -> auth

                                .requestMatchers(
                                        "/dashboard/**"
                                )
                                .hasAnyRole(
                                        "VIEWER",
                                        "ANALYST",
                                        "ADMIN"
                                )

                                .requestMatchers(
                                        "/records/**"
                                ).hasAnyRole(
                                        "ANALYST",
                                        "ADMIN"
                                )

                                .requestMatchers(
                                        "/users/**"
                                )
                                .hasRole("ADMIN")

                                .anyRequest()
                                .authenticated()
                        )
                        .build();
    }
}
