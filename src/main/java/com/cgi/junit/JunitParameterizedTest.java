package com.cgi.junit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * execute a single test multiple times with different parameters
 */
public class JunitParameterizedTest {
    private int numA;
    private int numB;
    private int expected;

    public JunitParameterizedTest(int numA, int numB, int expected) {
        this.numA = numA;
        this.numB = numB;
        this.expected = expected;
    }

    public static Collection<Object[]> data() {
        return Arrays.asList(
                new Object[]{1, 2, 3},
                new Object[]{0, 1, 1},
                new Object[]{-1, 4, 3}
        );
    }

    @Test
    public void testAdd() {
        assertEquals(expected, MathUtils.add(numA, numB));
    }

    @ParameterizedTest
    @ValueSource(strings = {"junit4", "junit5"})
    public void singleParameter(String username) {
        System.out.println(username);
    }
}

class MathUtils {
    public static int add(int a, int b) {
        return a + b;
    }
}