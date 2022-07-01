package com.firatyildiz.VetClinicManagementSystem.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception
    {
        httpSecurity.csrf().disable()
                .authorizeRequests()
                .mvcMatchers("/home").permitAll()
                .mvcMatchers("/owner/**").authenticated()
                .mvcMatchers("/pet/**").authenticated()
                .and().formLogin().loginPage("/login")
                .defaultSuccessUrl("/dashboard").failureUrl("/login?error=true").permitAll()
                .and().logout().logoutSuccessUrl("/login?logout=true").invalidateHttpSession(true).permitAll()
                .and().httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        auth.inMemoryAuthentication()
                .withUser("fırat").password("fırat").roles("ADMIN")
                .and().passwordEncoder(NoOpPasswordEncoder.getInstance());
    }
}
