package com.cgi.junit;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.beans.HasProperty.hasProperty;
import static org.hamcrest.beans.SamePropertyValuesAs.samePropertyValuesAs;
import static org.hamcrest.collection.IsEmptyCollection.empty;
import static org.hamcrest.text.IsEqualIgnoringCase.equalToIgnoringCase;

/**
 * third-party assertion libraries
 * make assertions more descriptive and readable
 */
public class JHamcrest {
    Calculator caculator = new Calculator();

    @Test
    public void testMatchers() {
        //text
        assertThat("foo", equalToIgnoringCase("Foo"));
        assertThat("", is(emptyString()));
        assertThat("foo", not(equalToIgnoringWhiteSpace(" Fooe")));

        //bean
        Calculator foo = new Calculator(0, "Bike", false);
        Calculator cloneFoo = new Calculator(0, "Bike", false);
        //hasProperty() works when the object has all the getter methods
        assertThat(foo, hasProperty("name"));
        //assertThat(foo, hasProperty("name", equalTo("Bike")));
        assertThat(foo, samePropertyValuesAs(cloneFoo));

        //collection
        List<String> list = new ArrayList<>();
        assertThat(list, empty());
        list.add("apple");
        assertThat(list, hasSize(1));
        list.addAll(Arrays.asList(new String[]{"banana", "grape"}));
        assertThat(list, contains("apple", "banana", "grape"));
        assertThat(list, hasItems("apple", "grape"));

        //number
        assertThat(5, greaterThan(3));
        assertThat(5, greaterThanOrEqualTo(4));
    }

    @Test
    public void testHamcrestInJunit4() {
        assertThat(caculator.add(4, 5), is(equalTo(9)));
    }

    /**
     * there is no assertThat in junit 5
     * use the assertThat provides by Hamcrest
     * which also accepts a Hamcrest Matcher
     */
    @org.junit.jupiter.api.Test
    public void testHamcrestInJunit5() {
        assertThat(caculator.add(4, 5), is(equalTo(9)));
    }
}
