package com.cgi.refactor;

import org.junit.Assert;
import org.junit.Test;

class OrderTest {
    @Test
    public void testGetPrice(){
        Order order = new Order(2, 4);
        Assert.assertEquals(8, order.getPrice(), 0);
    }
}