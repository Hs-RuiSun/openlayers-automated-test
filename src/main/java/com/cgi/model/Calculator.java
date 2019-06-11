package com.cgi.model;

public class Calculator {
    private Integer quantity;
    private String name;
    private boolean secondUsed;

    public Calculator() {
    }

    public Calculator(int quantity, String name, boolean secondUsed) {
        super();
        this.quantity = quantity;
        this.name = name;
        this.secondUsed = secondUsed;
    }

    public int add(int numA, int numB) {
        return numA + numB;
    }

    public String getName() {
        return name;
    }

    public boolean isSecondUsed() {
        return secondUsed;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSecondUsed(boolean secondUsed) {
        this.secondUsed = secondUsed;
    }
}
