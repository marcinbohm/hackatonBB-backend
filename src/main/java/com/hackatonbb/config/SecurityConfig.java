package com.hackatonbb.config;

import com.hackatonbb.repository.CategoryRepository;
import com.hackatonbb.repository.ClassRepository;
import com.hackatonbb.repository.PermissionRepository;
import com.hackatonbb.resource.session.SessionService;
import com.hackatonbb.resource.user.UserService;
import com.hackatonbb.security.PasswordEncoderImpl;
import com.hackatonbb.security.authentication.CurrentUserFacade;
import com.hackatonbb.security.authentication.CurrentUserFacadeImpl;
import com.hackatonbb.security.authentication.ProviderManagerImpl;
import com.hackatonbb.security.authentication.UserDetailsServiceImpl;
import com.hackatonbb.security.filter.JwtAuthenticationEntryPoint;
import com.hackatonbb.security.filter.JwtAuthenticationFilter;
import com.hackatonbb.security.jwt.JwtService;
import com.hackatonbb.security.jwt.JwtServiceImpl;
import com.hackatonbb.service.AuthenticationFacade;
import com.hackatonbb.service.AuthenticationFacadeImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@EnableWebSecurity
@Import(WebMvcConfig.class)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
        private final WebMvcConfig webMvcConfig;

    @Autowired
    private UserService userService;

    @Autowired
    private SessionService sessionService;

    @Autowired
    private ClassRepository classService;

    @Autowired
    private CategoryRepository categoryService;

    @Autowired
    private PermissionRepository permissionService;

    @Autowired
    private CurrentUserFacade currentUserFacade;

    public SecurityConfig(WebMvcConfig webMvcConfig) {
        this.webMvcConfig = webMvcConfig;
    }

    @Bean
    public AuthenticationFacade authenticationFacade() {
        return new AuthenticationFacadeImpl();
    }

    @Bean
    public CurrentUserFacade currentUserFacade() {
        return new CurrentUserFacadeImpl(classService, permissionService);
    }

    @Bean
    public JwtService jwtService() {
        return new JwtServiceImpl(sessionService, currentUserFacade, userService);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new PasswordEncoderImpl();
    }

    @Bean
    @Qualifier("JwtAuthenticationEntryPoint")
    public AuthenticationEntryPoint authenticationEntryPoint() {
        return new JwtAuthenticationEntryPoint(webMvcConfig.mappingJackson2HttpMessageConverter());
    }

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter() {
        return new JwtAuthenticationFilter(jwtService());
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl(this.userService, this.currentUserFacade());
    }

    @Bean
    public DaoAuthenticationProvider daoUserAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder());
        provider.setUserDetailsService(userDetailsService());

        return provider;
    }

    @Bean
    public DaoAuthenticationProvider daoPatientAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder());
        provider.setUserDetailsService(userDetailsService());

        return provider;
    }

    @Bean
    public AuthenticationManager authenticationManager() {
        List<AuthenticationProvider> providers = new ArrayList<>();
        providers.add(daoUserAuthenticationProvider());
        providers.add(daoPatientAuthenticationProvider());

        ProviderManagerImpl providerManager = new ProviderManagerImpl(providers);
        providerManager.setDaoAdminAuthenticationProvider(daoPatientAuthenticationProvider());
        providerManager.setDaoUserAuthenticationProvider(daoUserAuthenticationProvider());

        return providerManager;
    }

    @Bean
    public CorsFilter corsFilter() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.setAllowedOrigins(Collections.singletonList("*"));
        config.setAllowedHeaders(Collections.singletonList("*"));
        config.setAllowedMethods(Arrays.stream(HttpMethod.values()).map(HttpMethod::name).collect(Collectors.toList()));
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .cors()
                .and()
                .csrf()
                .disable()
                .exceptionHandling()
                //  .authenticationEntryPoint(authenticationEntryPoint())
                .and()
                .authorizeRequests()
                .antMatchers("/ping**").permitAll()
                .antMatchers("/auth/*").permitAll()
                .antMatchers("/actuator/**").permitAll()
                .anyRequest().authenticated();


        http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }
}
