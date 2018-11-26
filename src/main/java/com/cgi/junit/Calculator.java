package com.cgi.junit;

public class Calculator {
	int yearsUsed;
	String name;
	boolean secondUsed;
	
	public Calculator() {}
	
	public Calculator(int yearsUsed, String name, boolean secondUsed) {
		super();
		this.yearsUsed = yearsUsed;
		this.name = name;
		this.secondUsed = secondUsed;
	}

	public int add(int numA, int numB) {
		return numA + numB;
	}

	public int getYearsUsed() {
		return yearsUsed;
	}

	public String getName() {
		return name;
	}

	public boolean isSecondUsed() {
		return secondUsed;
	}
}
