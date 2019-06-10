package com.cgi.refactor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderTest {
    @Test
    public void testGetPrice(){
        Order order = new Order(2, 4);
        assertEquals(8, order.getPrice(), 0);
    }
}