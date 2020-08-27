package com.clps.java.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestReflection1 {

	public static void main(String[] args) throws Exception {

		// 获得 Class 类型对象的方式
		
		// 1、通过对象调用 getClass()方法来获取
		Person p1 = new Person();
		Class<?> c1 = p1.getClass();

		
		// 2、直接通过 类名.class 的方式得到,该方法最为安全可靠，程序性能更高
		// 这说明任何一个类都有一个隐含的静态成员变量 class
		Class<?> c2 = Person.class;

		
		// 3、通过 Class 对象的 forName() 静态方法来获取，用的最多，
		// 但可能抛出 ClassNotFoundException 异常
		Class<?> c3 = null;
		try {
			c3 = Class.forName("com.clps.java.reflection.Person");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		
		// 4、类加载器：getClassLoader().loadClass("full class name")
		Person.class.getClassLoader().loadClass("com.clps.java.reflection.Person");
		p1.getClass().getClassLoader().loadClass("com.clps.java.reflection.Person");
		
		System.out.println(c1 == c2);
		System.out.println(c1 == c3);
		System.out.println(c2 == c3);
		System.out.println(c1.equals(c2));
		System.out.println(c1.equals(c3));
		System.out.println(c2.equals(c3));
		System.out.println("----------");
		
		
		
		// 获得类的全名
		String className = c2.getName();
		System.out.println(className);
		System.out.println("----------");
		

		// 获得类的所有public的属性
		Field[] fields = c2.getFields();
		for (Field field : fields) {
			System.out.println(field.getName());
		}
		System.out.println("----------");
		
		
		// 获得类的所有属性包括私有的
		Field[] allFields = c2.getDeclaredFields();
		for (Field field : allFields) {
			System.out.println(field.getName());
		}
		System.out.println("----------");
		
		
		// 获得类的public类型的方法，这里包括 Object 类的一些方法
		Method[] methods = c2.getMethods();
		for (Method method : methods) {
			System.out.println(method.getName());
		}
		System.out.println("----------");
		
		
		// 获得类的所有方法
		Method[] allMethods = c2.getDeclaredMethods();
		for (Method method : allMethods) {
			System.out.println(method.getName());
		}
		System.out.println("----------");

		
		// 获得指定的属性
//		Field f1 = c2.getField("name");		// 私有的需要使用getDeclaredField()
		Field f1 = c2.getField("age");
		System.out.println(f1);
		System.out.println("----------");
		
		
		// 获得指定的私有属性
		Field f2 = c2.getDeclaredField("name");
		// 启用和禁用访问安全检查的开关，值为 true，则表示反射的对象在使用时应该取消 java 语言的访问检查；反之不取消
		f2.setAccessible(true);
		System.out.println(f2);
		System.out.println("----------");
		
		
		// 创建这个类的一个对象
		Object p2 = c2.newInstance();
		f2.set(p2, "Tom");
		System.out.println(p2);
		System.out.println("----------");
		
		
		// 使用反射机制可以打破封装性，导致了java对象的属性不安全。
		System.out.println(f2.get(p2));
		System.out.println("----------");
		
		
		// 获取构造方法
		Constructor[] constructors = c2.getConstructors();
		for (Constructor constructor : constructors) {
			System.out.println(constructor.toString());
		}

	}

}
