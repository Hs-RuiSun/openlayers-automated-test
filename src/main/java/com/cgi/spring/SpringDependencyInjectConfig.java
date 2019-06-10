package com.cgi.spring;

import com.cgi.junit.Calculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDependencyInjectConfig {
    @Bean
    public Calculator calculator() {
        return new Calculator(1, "SpringDependencyInjection", false);
    }
}
