package com.cgi.junit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @RunWith and @ContextConfiguration 
 * indicate that the class should use Spring's JUnit utilities and ApplicationContext
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringDependencyInjectConfig.class)
public class SpringDependencyInjectTest {
    /*//field injection
    @Autowired*/
    private Foo foo;
    /*private SpringDependencyInjectTest(Foo foo) {
        this.foo = foo;
    }*/
    
    @Test
    public void testSpringDependencyInject() {
        System.out.println(foo.name);
    }

    public Foo getFoo() {
        return foo;
    }

    public void setFoo(Foo foo) {
        this.foo = foo;
    }
}
