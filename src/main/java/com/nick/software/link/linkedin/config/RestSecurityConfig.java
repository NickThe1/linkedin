package com.nick.software.link.linkedin.config;

import com.nick.software.link.linkedin.JWT.JwtConfigurer;
import com.nick.software.link.linkedin.JWT.JwtTokenProvider;
import com.nick.software.link.linkedin.persistence.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class RestSecurityConfig extends WebSecurityConfigurerAdapter {

    private UserDetailsService userDetailsService;

    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    public RestSecurityConfig(UserDetailsService userDetailsService, JwtTokenProvider jwtTokenProvider) {
        this.userDetailsService = userDetailsService;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Bean
    public AuthenticationProvider authProvider(){

        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        daoAuthenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder());

        return daoAuthenticationProvider;
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests().antMatchers("/api/v0.1/auth").permitAll()
                .antMatchers("/api/v0.1/auth/login").permitAll()
                .antMatchers("/swagger-ui/").permitAll()
                .antMatchers("/api/v0.1/user/**").hasAuthority(Role.USER.toString())
                .antMatchers("/api/v0.1/vip/**").hasAuthority("VIP")
                .antMatchers("/api/v0.1/admin/**").hasAuthority("ADMIN")
                //.anyRequest().hasAuthority("USER")//не зайти в свеггер не залогинясь)
                .and()
                .apply(new JwtConfigurer(jwtTokenProvider));
    }
}
