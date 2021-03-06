package com.fina.fina.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        // securedEnabled = true,
        // jsr250Enabled = true,
        prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // http.cors().and().csrf().disable()
        // .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
        // .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
        // .authorizeRequests()
        // .antMatchers("/**").permitAll()
        // .anyRequest().authenticated()
        // .and()
        // .logout()
        // .permitAll()
        // .logoutUrl("/api/logout")
        // .deleteCookies("JSESSIONID")
        // .logoutSuccessUrl("/");

        // http.addFilterBefore(authenticationJwtTokenFilter(),
        // UsernamePasswordAuthenticationFilter.class);

        http.csrf().disable().authorizeRequests()
                .anyRequest().permitAll();

    }

}
