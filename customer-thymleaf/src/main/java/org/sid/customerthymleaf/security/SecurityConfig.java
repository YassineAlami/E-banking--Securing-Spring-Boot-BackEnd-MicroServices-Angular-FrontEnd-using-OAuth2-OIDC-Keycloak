package org.sid.customerthymleaf.security;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.web.SecurityFilterChain;

import org.springframework.security.oauth2.client.oidc.web.logout.OidcClientInitiatedLogoutSuccessHandler;



import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;
import org.springframework.security.oauth2.core.oidc.user.OidcUserAuthority;
import org.springframework.security.oauth2.core.user.OAuth2UserAuthority;

import java.util.*;

@Configuration
@AllArgsConstructor
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

    private ClientRegistrationRepository clientRegistrationRepository;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(Customizer.withDefaults())
                //hado maghaykheshoumch authentification
                .authorizeHttpRequests(ar->ar.requestMatchers("/","/oauth2Login/**","/webjars/**","h2-cnsole/**").permitAll())
                //ms ga3 les req li b9aw aykheshoum authentification
                .authorizeHttpRequests(ar->ar.anyRequest().authenticated())

                //had jouj bach n9dro naccederw l h2 db
                .headers(h->h.frameOptions(fo->fo.disable()))
                .csrf(csrf->csrf.ignoringRequestMatchers("/h2-console/**"))

                //tan7eded lih bli bghit ndir Authentification OAuth2.. whowa ghaymchi lapp.prop wghayl9a google
                .oauth2Login(ol->ol.loginPage("/oauth2Login").defaultSuccessUrl("/"))
                .logout((logout) -> logout
                        .logoutSuccessHandler(oidcLogoutSuccessHandler())
                        .logoutSuccessUrl("/").permitAll()
                        .clearAuthentication(true)
                        .deleteCookies("JSESSIONID"))
                .exceptionHandling(eh->eh.accessDeniedPage("/notAuthorized"))
                .build();
    }
    private OidcClientInitiatedLogoutSuccessHandler oidcLogoutSuccessHandler() {
        final OidcClientInitiatedLogoutSuccessHandler oidcLogoutSuccessHandler =
                new OidcClientInitiatedLogoutSuccessHandler(this.clientRegistrationRepository);
        oidcLogoutSuccessHandler.setPostLogoutRedirectUri("{baseUrl}?logoutsuccess=true");
        return oidcLogoutSuccessHandler;
    }

    //ghaydoz 3la lbeans dyal li kaynin flcontext dyal security.. ila l9ina un utilisateur li khedam b OpenID Connect tanakhdo lClaims dyalo wtanakhdo mnhom "realm_access" li fihom les Roles
    @Bean
    public GrantedAuthoritiesMapper userAuthoritiesMapper() {
        return (authorities) -> {
            final Set<GrantedAuthority> mappedAuthorities = new HashSet<>();
            authorities.forEach((authority) -> {
                if (authority instanceof OidcUserAuthority oidcAuth) {
                    mappedAuthorities.addAll(mapAuthorities(oidcAuth.getIdToken().getClaims()));
                    System.out.println(oidcAuth.getAttributes());
                } else if (authority instanceof OAuth2UserAuthority oauth2Auth) {
                    mappedAuthorities.addAll(mapAuthorities(oauth2Auth.getAttributes()));
                }
            });
            return mappedAuthorities;
        };
    }

    //hna tantsara 3la dok "Claim"s bach kolla "Claim" nakhod mnha "realm_access" li homa les roles
    private List<SimpleGrantedAuthority> mapAuthorities(final Map<String, Object> attributes) {
        final Map<String, Object> realmAccess = ((Map<String, Object>)attributes.getOrDefault("realm_access", Collections.emptyMap()));
        final Collection<String> roles = ((Collection<String>)realmAccess.getOrDefault("roles", Collections.emptyList()));
        return roles.stream()
                .map((role) -> new SimpleGrantedAuthority(role))
                .toList();
    }

}
