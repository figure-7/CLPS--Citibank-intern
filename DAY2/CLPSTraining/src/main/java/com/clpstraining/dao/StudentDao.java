package com.clpstraining.dao;

import com.clpstraining.entity.Student;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface StudentDao {
    /**
     * to save Student
     * @param student
     * @author Mingjian Cao
     * @return
     */
    Integer saveStudent(Student student);

    boolean removeStudent(Integer id);

    boolean updateStudent(Student student);

    Student getStudentById(Integer id);

    Integer countStudents();

    List<Student> listStudents();

    boolean batchInserStudent(List<Student> students);
}
