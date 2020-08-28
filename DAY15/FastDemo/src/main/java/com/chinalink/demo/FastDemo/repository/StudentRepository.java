package com.chinalink.demo.FastDemo.repository;

import java.util.List;

import com.chinalink.demo.FastDemo.entity.Student;

public interface StudentRepository {

	public List<Student> findAll();
    public Student findById(Long id);
    public int save(Student student);
    public int update(Student student);
    public int deleteById(Long id);
}
