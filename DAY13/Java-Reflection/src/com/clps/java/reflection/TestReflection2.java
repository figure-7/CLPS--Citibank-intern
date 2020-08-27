package com.clps.java.reflection;

import java.lang.reflect.Field;

import org.junit.Test;

public class TestReflection2 {

	@Test
	public void testGetParentField() throws Exception {
		Class<?> c1 = Class.forName("com.clps.java.reflection.SubClass");
		
		System.out.println(c1.getSuperclass());
		
		Class<?> s1 = c1.getSuperclass();
		
		
		Field[] allFields = s1.getDeclaredFields();
		for (Field field : allFields) {
			System.out.println(field.getName());
		}
		
	}

}