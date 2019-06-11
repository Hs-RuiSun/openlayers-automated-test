package com.cgi.model;

import com.cgi.model.Calculator;

public interface CalculatorDao {
    public int getQuantityInStock();

    public Calculator save(Calculator calculator);

    public Calculator findOne(String name, Integer quantity);

    public String getLabelMessage(String name);

    public void compare(Calculator... calculator);
}
