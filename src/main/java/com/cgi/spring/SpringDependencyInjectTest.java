package com.cgi.spring;

import com.cgi.junit.Calculator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * @RunWith and @ContextConfiguration
 * indicate that the class should use Spring's JUnit utilities and ApplicationContext
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = SpringDependencyInjectConfig.class)
public class SpringDependencyInjectTest {
    /*//field injection
    @Autowired*/
    private Calculator calculator;
    /*private SpringDependencyInjectTest(Caculator caculator) {
        this.caculator = caculator;
    }*/

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
