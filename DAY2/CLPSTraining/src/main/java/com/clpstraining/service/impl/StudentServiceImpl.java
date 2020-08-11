package com.clpstraining.service.impl;

import com.clpstraining.dao.StudentDao;
import com.clpstraining.entity.Student;
import com.clpstraining.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public Integer saveStudent(Student student) {
        return studentDao.saveStudent(student);
    }

    @Override
    public boolean removeStudent(Integer id) {
        return studentDao.removeStudent(id);
    }

    @Override
    public boolean updateStudent(Student student) {
        return studentDao.updateStudent(student);
    }

    @Override
    public Student getStudentById(Integer id) {
        return studentDao.getStudentById(id);
    }

    @Override
    public Integer countStudents() {
        return studentDao.countStudents();
    }

    @Override
    public List<Student> listStudents() {
        return studentDao.listStudents();
    }

    @Override
    public boolean batchInserStudent(List<Student> students) {
        return studentDao.batchInserStudent(students);
    }
}
