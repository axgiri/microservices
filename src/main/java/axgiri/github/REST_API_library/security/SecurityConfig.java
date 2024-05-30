package axgiri.github.REST_API_library.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig{
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
    throws Exception {
        http.authorizeHttpRequests((requests) -> requests
        .requestMatchers("/signUp", "/index").permitAll()
        .anyRequest().authenticated())
        .formLogin((form) -> form
        .loginPage("/index")
        .permitAll())
        .logout((logout) -> logout
        .permitAll());
        return http.build();
    }
}
