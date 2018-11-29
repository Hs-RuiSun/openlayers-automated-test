package com.cgi.junit;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class JunitParameterizedTest {
	int numA;
	int numB;
	int expected;
	
	@Parameters
	public Collection<Object[]> data(){
		return Arrays.asList(new Object[][] {
			{1, 2, 3},
			{0, 1, 1},
			{-1, 4, 3}
		});
	}
	
	@Test
	public void testAdd() {
		assertEquals(expected, MathUtils.add(numA, numB));
	}

    @ParameterizedTest
    @ValueSource( strings = {"junit4", "junit5"} )
    public void singleParameter(String username) {
        System.out.println(username);
    }
}

class MathUtils{
	public static int add(int a, int b) {
		return a+b;
	}
}