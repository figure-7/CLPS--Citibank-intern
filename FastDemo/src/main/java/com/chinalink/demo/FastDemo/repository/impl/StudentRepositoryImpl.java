package com.chinalink.demo.FastDemo.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.chinalink.demo.FastDemo.entity.Student;
import com.chinalink.demo.FastDemo.repository.StudentRepository;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Student> findAll() {
		List<Student> studentList = new ArrayList<Student>();
		studentList = jdbcTemplate.query("select * from student", new BeanPropertyRowMapper<Student>(Student.class));
		return studentList;
	}

	@Override
	public Student findById(Long id) {
		return null;
	}

	@Override
	public int save(Student student) {
		return 0;
	}

	@Override
	public int update(Student student) {
		return 0;
	}

	@Override
	public int deleteById(Long id) {
		return 0;
	}

}
