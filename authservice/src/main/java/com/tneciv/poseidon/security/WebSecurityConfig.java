package com.tneciv.poseidon.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.sql.DataSource;

@SuppressWarnings("SpringJavaAutowiringInspection")
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers(HttpMethod.POST, "/login").permitAll()
                .anyRequest().authenticated()
                .and()
                // We filter the api/login requests
                .addFilterBefore(new JWTLoginFilter("/login", authenticationManager()),
                        UsernamePasswordAuthenticationFilter.class)
                // And filter other requests to check the presence of JWT in header
                .addFilterBefore(new JWTAuthenticationFilter(),
                        UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        // http://stackoverflow.com/questions/18104809/using-spring-security-websecurityconfigureradapter-auth-jdbcauthentication-u
        //auth.jdbcAuthentication()
        //        .dataSource(dataSource)
        //        .usersByUsernameQuery("select username as principal, password as credentials, true from users where username = ?")
        //        .authoritiesByUsernameQuery("select username as principal, authority as role from authorities where username = ?")
        //        .rolePrefix("ROLE_");

        //http://stackoverflow.com/questions/24174884/spring-security-jdbcauthentication-default-scheme-error-on-postgresql
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery(
                        "SELECT username , password , enabled FROM users WHERE username = ?")
                .authoritiesByUsernameQuery(
                        "SELECT u.username AS user , r.role AS role FROM users u LEFT JOIN roles r ON u.role_id = r.id WHERE u.username = ?");
    }

}