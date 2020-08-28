package com.chinalink.demo.FastDemo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "my_student")
//实体类与集合的映射，value 可以指定集合名，若省略，默认取首字母小写之后的类名作为集合名。可以从MongoDB中验证。
public class StudentMongo {

	@Id
    private String id;
    @Field(value = "student_age")
    //普通属性到字段映射，value 可以指定字段名，若省略，默认取对应的属性名作为字段名
    private int age;
    @Field(value = "student_name")
    private String name;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
