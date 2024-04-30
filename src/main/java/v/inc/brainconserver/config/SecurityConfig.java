package v.inc.brainconserver.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import v.inc.brainconserver.config.filters.JwtAuthenticationFilter;

import static org.springframework.http.HttpMethod.*;
import static v.inc.brainconserver.domain.Permission.*;
import static v.inc.brainconserver.domain.Role.MENTOR;
import static v.inc.brainconserver.domain.Role.STUDENT;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity
public class SecurityConfig {

    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity
                .csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/api/v1/auth/**").permitAll()

                .requestMatchers("/api/v1/student/**").hasAnyRole(MENTOR.name(), STUDENT.name())

                .requestMatchers(GET, "/api/v1/student/**").hasAnyAuthority(MENTOR_READ.name(), STUDENT_READ.name())
                .requestMatchers(POST, "/api/v1/student/**").hasAnyAuthority(MENTOR_CREATE.name(), STUDENT_CREATE.name())
                .requestMatchers(PUT, "/api/v1/student/**").hasAnyAuthority(MENTOR_UPDATE.name(), STUDENT_UPDATE.name())
                .requestMatchers(DELETE, "/api/v1/student/**").hasAnyAuthority(MENTOR_DELETE.name(), STUDENT_DELETE.name())


                .anyRequest().authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return httpSecurity.build();
    }
}
