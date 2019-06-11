package com.cgi.spring;

import com.cgi.model.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.test.context.*;
import org.springframework.test.context.junit.jupiter.*;

/**
 * @ExtendWith and @ContextConfiguration
 * indicate that the class should use Spring's JUnit utilities and ApplicationContext
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = SpringConfig.class)
public class SpringDependencyInjectTest {
    @Autowired
    private Calculator calculator;

    @Test
    public void testSpringDependencyInject() {
        System.out.println(calculator.getName());
    }

    public Calculator getCalculator() {
        return calculator;
    }

    public void setCalculator(Calculator calculator) {
        this.calculator = calculator;
    }
}
