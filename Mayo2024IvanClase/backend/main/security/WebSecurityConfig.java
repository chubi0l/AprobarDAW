package backend.main.security;

@Configuration
public class WebSecurityConfig {
    public SecurityFilterChain apiFilterChain(HttpSecurity http) {
    http.authorizeHttpRequests(authorize -> authorize
        // PRIVATE ENDPOINTS
        // ROLE_CLIENT, ROLE_ADMIN
        .requestMatchers("/api/v1/funkos/").hasRole("ROLE_CLIENT", "ROLE_ADMIN") // yo pondria .permitAll()
        .requestMatchers("/api/v1/funkos/**/address").hasRole("ROLE_CLIENT", "ROLE_ADMIN")
        .requestMatchers("/api/v1/funkos/*").hasRole("ROLE_ADMIN")
    );
}
}
