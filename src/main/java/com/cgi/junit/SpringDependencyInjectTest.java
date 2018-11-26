package com.cgi.junit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @RunWith and @ContextConfiguration 
 * indicate that the class should use Spring's JUnit utilities and ApplicationContext
 */
@RunWith(SpringJUnit4ClassRunner.class)
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
        System.out.println(calculator.name);
    }

    public Calculator getCalculator() {
        return calculator;
    }

    public void setCalculator(Calculator calculator) {
        this.calculator = calculator;
    }
}
