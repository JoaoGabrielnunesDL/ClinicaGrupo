package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain springSecurityFilterProperties(ServerHttpSecurity http) {
        http
                // Desabilita o CSRF porque usaremos tokens JWT
                .csrf(csrf -> csrf.disable())

                // Define quais rotas são públicas ou protegidas
                .authorizeExchange(exchanges -> exchanges
                        // 1. Microsserviço Administrativo (Geovani) - Porta 8081
                        .pathMatchers("/api/admin/auth/**").permitAll()
                        .pathMatchers("/api/admin/**").permitAll()

                        // 2. Microsserviço de Agendamento (João) - Porta 8082
                        .pathMatchers("/api/agendamento/**").permitAll()

                        // 3. Microsserviço de Atendimento (Lucas S.) - Porta 8083
                        .pathMatchers("/api/atendimento/**").permitAll()

                        // Qualquer outra requisição para qualquer microsserviço exige autenticação
                        .anyExchange().authenticated()
                );

        return http.build();
    }
}