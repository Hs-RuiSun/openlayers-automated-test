package com.cgi.junit;

import org.hamcrest.CoreMatchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

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
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test(expected = IndexOutOfBoundsException.class)
    public void empty() {
        new ArrayList<>().get(0);
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

    @Test
    public void expectedExceptionRule() throws IndexOutOfBoundsException {
        thrown.expect(IndexOutOfBoundsException.class);
        thrown.expectMessage("Index: 0, Size: 0");
        thrown.expectMessage(CoreMatchers.containsString("Index: 0"));
        new ArrayList<>().get(0);
    }
}
