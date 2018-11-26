package com.cgi.junit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith( CalculatorParameterResolver.class )
public class CalculatorTest {
    @Test
    public void testIt(Calculator instance) {
        System.out.println(instance.name);
    }
}