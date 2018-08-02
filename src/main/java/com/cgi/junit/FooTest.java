package com.cgi.junit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith( FooParameterResolver.class )
public class FooTest {
    @Test
    public void testIt(Foo fooInstance) {
        System.out.println(fooInstance.name);
    }
}