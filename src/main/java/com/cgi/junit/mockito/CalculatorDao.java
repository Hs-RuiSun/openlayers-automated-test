package com.cgi.junit.mockito;

import com.cgi.junit.Calculator;

public interface CalculatorDao {
	public int getQuantityInStock();
	public Calculator save(Calculator calculator);
	public Calculator findOne(String name, Integer quantity);
	public String getLabelMessage(String name);
	public void compare(Calculator ...calculator);
}
