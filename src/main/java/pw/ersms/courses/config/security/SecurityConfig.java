package pw.ersms.courses.config.security;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;


@Configuration
@EnableWebSecurity
public class SecurityConfig{

    @Autowired private JwtTokenFilter jwtTokenFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        //allow all requests (even if the user doesnt have credentials)
//        http
//                .authorizeHttpRequests((authz) -> authz
//                        .requestMatchers("/course/**").hasAnyAuthority("SysAdmin", "FireAdmin","User")
//                        .anyRequest().permitAll()
//                )
//                .csrf().disable();
//        http.exceptionHandling()
//                .authenticationEntryPoint(
//                        (request, response, ex) -> {
//                            response.sendError(
//                                    HttpServletResponse.SC_UNAUTHORIZED,
//                                    ex.getMessage()
//                            );
//                        }
//                );

//        http.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);

        http
                .csrf()
                .disable()
                .cors().configurationSource(c -> {
                    CorsConfiguration corsCfg = new CorsConfiguration();
                    corsCfg.applyPermitDefaultValues();
                    corsCfg.addAllowedOriginPattern("*");
                    corsCfg.addAllowedMethod(CorsConfiguration.ALL);
                    return corsCfg;
                })
                .and()
                .authorizeHttpRequests()
                .requestMatchers("/swagger-ui/**",
                        "/v3/api-docs/**")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }


}
