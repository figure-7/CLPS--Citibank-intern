package com.chinalink.demo.FastDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chinalink.demo.FastDemo.entity.Student;
import com.chinalink.demo.FastDemo.entity.StudentMongo;
import com.chinalink.demo.FastDemo.mongodb.repository.StudentRepositoryMongoDB;
import com.chinalink.demo.FastDemo.repository.StudentRepository;
import com.chinalink.demo.FastDemo.repository.StudentRepositoryMyBatis;

@RestController
@RequestMapping("student")
public class StudentController {

	@Autowired
	private StudentRepositoryMyBatis studentRepositoryMybatis;
	
	@Autowired
	private StudentRepositoryMongoDB studentRepositoryMongoDB;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@GetMapping("/findAll")
    public List<Student> findAll(){
        return studentRepository.findAll();
    }
	
	@GetMapping("/findAllMybatis")
    public List<Student> findAllMybatis(){
        return studentRepositoryMybatis.findAll();
    }
	
	@GetMapping("/findAllMongoDB")
    public List<StudentMongo> findAllMongoDB(){
        return studentRepositoryMongoDB.findAll();
    }

    @GetMapping("/findById/{id}")
    public Student get(@PathVariable("id") Long id){
    	Student stu = new Student();
        stu = studentRepository.findById(id);
        return stu;
    }
    
    @GetMapping("/getStudentForMongoDB/{id}")
    public StudentMongo getStudentForMongoDB(@PathVariable("id") String id){
    	StudentMongo stu = new StudentMongo();
        stu = studentRepositoryMongoDB.findById(id).get();
        return stu;
    }

    @PostMapping("/save")
    public int save(@RequestBody Student student){
        return studentRepository.save(student);
    }

    @PutMapping("/update")
    public int update(@RequestBody Student student){
        return studentRepository.update(student);
    }

    @DeleteMapping("/deleteById/{id}")
    public int deleteById(@PathVariable("id") Long id){
        return studentRepository.deleteById(id);
    }
}
