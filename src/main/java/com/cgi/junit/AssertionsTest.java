package com.cgi.junit;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AssertionsTest {
    @Test
    public void test(){
        List<String> list = Arrays.asList("abc", "efg");
        List<String> expected = Arrays.asList("abc", "efg");
        assertIterableEquals(expected, list);

        assertArrayEquals(new int[]{1,2}, new int[]{1,2});

        assertNotSame(new String("abc"), new String("abc"));

        assertThrows(IndexOutOfBoundsException.class, () -> {
            new ArrayList<>().get(0);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            Integer.parseInt("one");
        });
    }

    @Test
    public void testExpectedException() {
        assertThrows(IndexOutOfBoundsException.class,
                () -> { new ArrayList<>().get(0);});
    }

    @Test
    public void testExpectedExceptionWithSuperType() {
        assertThrows(IllegalArgumentException.class,
                () -> { Integer.parseInt("one"); }, //actually throw NumberFormatException which extends IllegalArgumentException
                "For input string: \"one\""
        );
    }
}
