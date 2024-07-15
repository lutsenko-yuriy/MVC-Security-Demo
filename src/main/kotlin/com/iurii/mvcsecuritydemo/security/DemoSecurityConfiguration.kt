package com.iurii.mvcsecuritydemo.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.core.userdetails.User
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import org.springframework.security.provisioning.UserDetailsManager

@Configuration
class DemoSecurityConfiguration {

    @Bean
    fun userDetailsManager(): UserDetailsManager {
        val john = User.builder()
            .username("john")
            .password("{noop}Test123")
            .roles("EMPLOYEE")
            .build()

        val mary = User.builder()
            .username("mary")
            .password("{noop}Test123")
            .roles("EMPLOYEE", "MANAGER")
            .build()

        val susan = User.builder()
            .username("susan")
            .password("{noop}Test123")
            .roles("EMPLOYEE", "MANAGER", "ADMIN")
            .build()

        return InMemoryUserDetailsManager(john, mary, susan)
    }
}