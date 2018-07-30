package com.cgi.junit5;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class JunitParameterizedTest {
    
    @Test
    public void multipleParameters() {
        
    }
    
    @ParameterizedTest
    @ValueSource(strings = {"junit4", "junit5"})
    public void singleParameter(String username) {
        System.out.println(username);
    }
}