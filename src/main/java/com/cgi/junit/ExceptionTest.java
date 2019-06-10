package com.cgi.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.fail;
import static org.testng.Assert.assertThrows;

/**
 * verify code throws exceptions as expected
 *
 * @author ruby.sun Aug 1, 2018
 */
public class ExceptionTest {
    // junit 5
    @org.junit.jupiter.api.Test
    public void testExpectedException() {
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            new ArrayList<>().get(0);
        });
    }

    @org.junit.jupiter.api.Test
    public void testExpectedExceptionWithSuperType() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Integer.parseInt("one");
        });
    }

    // junit 4
//    @Rule
//    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void empty() {
        assertThrows(IndexOutOfBoundsException.class, () -> new ArrayList<>().get(0));
    }

    @Test
    public void testExceptionMessage() {
        try {
            new ArrayList<>().get(0);
            fail("expect an IndexOutOfBoundsException to be thrown");
        } catch (IndexOutOfBoundsException e) {
            assertThat(e.getMessage(), is("Index: 0, Size: 0"));
        }
    }
}
