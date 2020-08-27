package com.clps.java.reflection;

public class Person {
	// ˽������
	private String name = "Lucy";
	
	String gender = "male";
	
	protected String city = "Dalian";
	
	// ��������
	public int age = 18;

	
	
	// ���췽��
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



	// ˽�з���
	private void say() {
		System.out.println("private say()...");
	}

	// ���з���
	public void work() {
		System.out.println("public work()...");
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", gender=" + gender + ", city=" + city + ", age=" + age + "]";
	}

}