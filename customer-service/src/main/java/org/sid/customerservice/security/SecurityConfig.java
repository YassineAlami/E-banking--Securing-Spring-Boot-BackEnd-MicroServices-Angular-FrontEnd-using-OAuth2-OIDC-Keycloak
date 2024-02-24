package org.sid.customerservice.security;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig {
    private JwtAuthConverter jwtAuthConverter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                //had ster + dik lbean li lte7t bach f Angular maygolchi lina dak lmochkil dyal lCORS.. la hada mn 8082 lakhor mn 8085
                .cors(Customizer.withDefaults())
                //l'authentification Staeless (pas de session cote serveur)
                .sessionManagement(sm-> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                //desactiver CSRF
                .csrf(csrf->csrf.disable())
                //bach ngoulih ay 7aja f api/customers aykhsek tkoun USER bach tacceder liha // l'eqivalent dyalha f RestController : @PreAuthorize("hasAuthority('USER')")
                //.authorizeHttpRequests(ar->ar.requestMatchers("/api/customers/**").hasAnyAuthority("USER"))
                //ga3 les reqs khashom ahthentification
                .authorizeHttpRequests(ar->ar.anyRequest().authenticated())
                //bima3na ghadi nproteger service par JWT
                .oauth2ResourceServer(ors->ors.jwt(jwt->jwt.jwtAuthenticationConverter(jwtAuthConverter)))

                .build();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("*"));
        configuration.setAllowedHeaders(Arrays.asList("*"));
        configuration.setExposedHeaders(Arrays.asList("*"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

}
