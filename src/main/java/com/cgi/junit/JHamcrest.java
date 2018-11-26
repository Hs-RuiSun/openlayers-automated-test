package com.cgi.junit;

import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Test;

import com.fasterxml.jackson.databind.jsontype.impl.AsExistingPropertyTypeSerializer;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.text.IsEqualIgnoringCase.equalToIgnoringCase;
import static org.hamcrest.beans.HasProperty.hasProperty;
import static org.hamcrest.beans.SamePropertyValuesAs.samePropertyValuesAs;
import static org.hamcrest.collection.IsEmptyCollection.empty;

import static com.cgi.junit.IsAPositiveInteger.isAPositiveInteger;
/**
 * third-party assertion libraries
 * make assertions more descriptive and readable
 */
public class JHamcrest {
	Caculator caculator = new Caculator();
	
	@Test
	public void testMatchers() {
		//text
		assertThat("foo", equalToIgnoringCase("Foo"));
		assertThat("", is(emptyString()));
		assertThat("foo", not(equalToIgnoringWhiteSpace(" Fooe")));
		
		//bean
		Foo foo = new Foo(0, "Bike", false);
		Foo cloneFoo = new Foo(0, "Bike", false);
		//hasProperty() works when the object has all the getter methods
		assertThat(foo, hasProperty("name"));
		assertThat(foo, hasProperty("name", equalTo("Bike")));
		assertThat(foo, samePropertyValuesAs(cloneFoo));
		
		//collection
		List<String> list = new ArrayList<>();
		assertThat(list, empty());
		list.add("apple");
		assertThat(list, hasSize(1));
		list.addAll(Arrays.asList(new String[] {"banana", "grape"}));
		assertThat(list, contains("apple", "banana", "grape"));
		assertThat(list, hasItems("apple", "grape"));
		
		//number
		assertThat(5, greaterThan(3));
		assertThat(5, greaterThanOrEqualTo(4));
		assertThat(5, isAPositiveInteger());
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
		org.hamcrest.MatcherAssert.assertThat(caculator.add(4, 5), is(equalTo(9)));
	}
}

//customerize Matcher
class IsAPositiveInteger extends TypeSafeMatcher<Integer> {
	@Factory
	public static Matcher<Integer> isAPositiveInteger() {
		return new IsAPositiveInteger();
	}

	@Override
	public void describeTo(Description description) {
		description.appendText("a positive Integer");
	}

	@Override
	protected boolean matchesSafely(Integer integer) {
		return integer > 0;
	}
	
}
