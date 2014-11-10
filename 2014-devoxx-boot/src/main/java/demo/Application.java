package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Application {

    @Bean
    public HealthIndicator devoxxHealthIndicator() {
        return new HealthIndicator() {
            @Override
            public Health health() {
                return Health.up().withDetail("counter", 42).build();
            }
        };
    }

    @Configuration
    static class SecurityConfig extends GlobalAuthenticationConfigurerAdapter {
        @Override
        public void init(AuthenticationManagerBuilder auth) throws Exception {
            auth.inMemoryAuthentication().withUser("hero").password("hero").roles("HERO", "USER");
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
