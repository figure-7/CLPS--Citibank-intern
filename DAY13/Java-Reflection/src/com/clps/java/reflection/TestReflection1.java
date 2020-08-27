package com.clps.java.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestReflection1 {

	public static void main(String[] args) throws Exception {

		// ��� Class ���Ͷ���ķ�ʽ
		
		// 1��ͨ��������� getClass()��������ȡ
		Person p1 = new Person();
		Class<?> c1 = p1.getClass();

		
		// 2��ֱ��ͨ�� ����.class �ķ�ʽ�õ�,�÷�����Ϊ��ȫ�ɿ����������ܸ���
		// ��˵���κ�һ���඼��һ�������ľ�̬��Ա���� class
		Class<?> c2 = Person.class;

		
		// 3��ͨ�� Class ����� forName() ��̬��������ȡ���õ���࣬
		// �������׳� ClassNotFoundException �쳣
		Class<?> c3 = null;
		try {
			c3 = Class.forName("com.clps.java.reflection.Person");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		
		// 4�����������getClassLoader().loadClass("full class name")
		Person.class.getClassLoader().loadClass("com.clps.java.reflection.Person");
		p1.getClass().getClassLoader().loadClass("com.clps.java.reflection.Person");
		
		System.out.println(c1 == c2);
		System.out.println(c1 == c3);
		System.out.println(c2 == c3);
		System.out.println(c1.equals(c2));
		System.out.println(c1.equals(c3));
		System.out.println(c2.equals(c3));
		System.out.println("----------");
		
		
		
		// ������ȫ��
		String className = c2.getName();
		System.out.println(className);
		System.out.println("----------");
		

		// ����������public������
		Field[] fields = c2.getFields();
		for (Field field : fields) {
			System.out.println(field.getName());
		}
		System.out.println("----------");
		
		
		// �������������԰���˽�е�
		Field[] allFields = c2.getDeclaredFields();
		for (Field field : allFields) {
			System.out.println(field.getName());
		}
		System.out.println("----------");
		
		
		// ������public���͵ķ������������ Object ���һЩ����
		Method[] methods = c2.getMethods();
		for (Method method : methods) {
			System.out.println(method.getName());
		}
		System.out.println("----------");
		
		
		// ���������з���
		Method[] allMethods = c2.getDeclaredMethods();
		for (Method method : allMethods) {
			System.out.println(method.getName());
		}
		System.out.println("----------");

		
		// ���ָ��������
//		Field f1 = c2.getField("name");		// ˽�е���Ҫʹ��getDeclaredField()
		Field f1 = c2.getField("age");
		System.out.println(f1);
		System.out.println("----------");
		
		
		// ���ָ����˽������
		Field f2 = c2.getDeclaredField("name");
		// ���úͽ��÷��ʰ�ȫ���Ŀ��أ�ֵΪ true�����ʾ����Ķ�����ʹ��ʱӦ��ȡ�� java ���Եķ��ʼ�飻��֮��ȡ��
		f2.setAccessible(true);
		System.out.println(f2);
		System.out.println("----------");
		
		
		// ����������һ������
		Object p2 = c2.newInstance();
		f2.set(p2, "Tom");
		System.out.println(p2);
		System.out.println("----------");
		
		
		// ʹ�÷�����ƿ��Դ��Ʒ�װ�ԣ�������java��������Բ���ȫ��
		System.out.println(f2.get(p2));
		System.out.println("----------");
		
		
		// ��ȡ���췽��
		Constructor[] constructors = c2.getConstructors();
		for (Constructor constructor : constructors) {
			System.out.println(constructor.toString());
		}

	}

}
