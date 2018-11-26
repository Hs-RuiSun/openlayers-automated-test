package com.cgi.junit;

public class Foo {
    int age;
    String name;
    boolean female;

    public Foo(int age, String name, boolean female) {
        this.age = age;
        this.name = name;
        this.female = female;
    }

	public int getAge() {
		return age;
	}

	public String getName() {
		return name;
	}

	public boolean isFemale() {
		return female;
	}
    
    
}
