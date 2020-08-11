package com.clpstraining.controller;

import com.clpstraining.entity.Student;
import com.clpstraining.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TestController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/countStudents")
    @ResponseBody
    public Integer countStudents(){
        return studentService.countStudents();
    }

    @RequestMapping("/listStudents")
    @ResponseBody
    public List<Student> listStudents(){
        return studentService.listStudents();
    }

    @RequestMapping("/getStudentsById")
    @ResponseBody
    public Student getStudentsById(){
        return studentService.getStudentById(5);
    }
    @RequestMapping("/saveStudent")
    @ResponseBody
    public Integer saveStudent(){
        Student student = new Student();
        student.setName("Zhang San");
        student.setGrade(2);
        student.setMajor("Law");
        student.setComment("Good person");
        return studentService.saveStudent(student);
    }

    @RequestMapping("/removeStudentById")
    @ResponseBody
    public boolean removeStudentById(){
        return studentService.removeStudent(5);
    }

    @RequestMapping("/batchSaveStudents")
    @ResponseBody
    public boolean batchSaveStudents(){
        List<Student> toSaveStudents = new ArrayList<>();
        Student student = new Student();
        student.setName("Zhang Yi");
        student.setGrade(1);
        student.setMajor("English");
        student.setComment("Good person1");
        toSaveStudents.add(student);
        student = new Student();
        student.setName("Zhang Er");
        student.setGrade(2);
        student.setMajor("Biology");
        student.setComment("Good person3");
        toSaveStudents.add(student);
        return studentService.batchInserStudent(toSaveStudents);
    }

}
