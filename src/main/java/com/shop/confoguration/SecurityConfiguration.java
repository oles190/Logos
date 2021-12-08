package com.shop.confoguration;

import com.shop.confoguration.jwt.JwtFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity( prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


    @Autowired
    private JwtFilter jwtFilter;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                 .csrf().disable()
                 .httpBasic().disable()
                 .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                 .and()
     //          .antMatcher("/**")
                 .authorizeRequests()
       //        .antMatchers("/").permitAll()
                 .antMatchers("/registration").permitAll()
                 .antMatchers("/login").permitAll()
                 .anyRequest().authenticated()
                 .and()
                 .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);





}
}


