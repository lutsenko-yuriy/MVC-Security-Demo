package com.iurii.mvcsecuritydemo.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.provisioning.JdbcUserDetailsManager
import org.springframework.security.provisioning.UserDetailsManager
import org.springframework.security.web.SecurityFilterChain
import javax.sql.DataSource

@Configuration
class DemoSecurityConfiguration {

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http.authorizeHttpRequests {
            it
                .requestMatchers("/").hasRole("EMPLOYEE")
                .requestMatchers("/leaders/**").hasRole("MANAGER")
                .requestMatchers("/systems/**").hasRole("ADMIN")
                .anyRequest().authenticated()
        }
            .formLogin {
                it.loginPage("/login")
                    .loginProcessingUrl("/authenticateTheUser")
                    .permitAll()
            }
            .logout {
                it.permitAll()
            }
            .exceptionHandling {
                it.accessDeniedPage("/access-denied")
            }
        return http.build()
    }

    @Bean
    fun userDetailsManager(dataSource: DataSource): UserDetailsManager {
        return JdbcUserDetailsManager(dataSource).apply {
            usersByUsernameQuery = "SELECT user_id, pw, active FROM members WHERE user_id=?"
            setAuthoritiesByUsernameQuery("SELECT user_id, role FROM roles WHERE user_id=?")
        }
    }
}