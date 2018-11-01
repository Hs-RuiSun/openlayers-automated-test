package com.cgi.junit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDependencyInjectConfig {
    @Bean
    public Foo foo() {
        return new Foo(1, "SpringDependencyInjection");
    }
}
