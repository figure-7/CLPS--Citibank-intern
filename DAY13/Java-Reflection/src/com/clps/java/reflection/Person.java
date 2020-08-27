package com.clps.java.reflection;

public class Person {
	// 私有属性
	private String name = "Lucy";
	
	String gender = "male";
	
	protected String city = "Dalian";
	
	// 公有属性
	public int age = 18;

	
	
	// 构造方法
	public Person() {
	}
	
	public Person(String name, String gender, String city) {
		this.name = name;
		this.gender = gender;
		this.city = city;
	}

	public Person(String name, String gender, String city, int age) {
		this.name = name;
		this.gender = gender;
		this.city = city;
		this.age = age;
	}



	// 私有方法
	private void say() {
		System.out.println("private say()...");
	}

	// 公有方法
	public void work() {
		System.out.println("public work()...");
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", gender=" + gender + ", city=" + city + ", age=" + age + "]";
	}

}