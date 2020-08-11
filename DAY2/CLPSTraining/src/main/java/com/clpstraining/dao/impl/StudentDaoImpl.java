package com.clpstraining.dao.impl;

import com.clpstraining.dao.StudentDao;
import com.clpstraining.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Integer saveStudent(Student student) {
        StringBuilder sql = new StringBuilder("insert into trainingstudent(name,grade,major,comment) ");
        sql.append("values ");
        sql.append("(?,?,?,?)");

        return jdbcTemplate.update(sql.toString(),new Object[]{});
    }

    @Override
    public boolean removeStudent(Integer id) {
        String sql = "delete from trainingstudent where id=?";
        return jdbcTemplate.update(sql.toString(),id) > 0;
    }

    @Override
    public boolean updateStudent(Student student) {
        StringBuilder sql = new StringBuilder("update trainingstudent set name=? ");
        sql.append(" where id=?");

        List params = new ArrayList();
        if( student.getGrade() > 0) {
            sql.append(",grade=?");
            params.add(student.getGrade());
        }
        params.add(student.getId());
        return jdbcTemplate.update(sql.toString(),params.toArray()) > 0;
    }

    @Override
    public Student getStudentById(Integer id) {
        String sql = new String("select id,name,grade,major,comment from trainingstudent where id=?");
        return jdbcTemplate.queryForObject(sql,new Object[]{id},new BeanPropertyRowMapper<>(Student.class));
    }

    @Override
    public Integer countStudents() {
        String sql = new String("select count(1) from trainingstudent");
        return jdbcTemplate.queryForObject(sql.toString(), Integer.class);
    }

    @Override
    public List<Student> listStudents() {
        String sql = new String("select id,name,grade,major,comment from trainingstudent");
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Student.class));

//        jdbcTemplate.queryForObject();
//        return jdbcTemplate.queryForList(sql, Student.class);
    }

    @Override
    public boolean batchInserStudent(List<Student> students) {
        StringBuilder sql = new StringBuilder("insert into trainingstudent(name,grade,major,comment) ");
        sql.append("values ");
        sql.append("(?,?,?,?)");
        return  jdbcTemplate.batchUpdate(sql.toString(), new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                preparedStatement.setString(1,students.get(i).getName());
                preparedStatement.setInt(2,students.get(i).getGrade());
                preparedStatement.setString(3,students.get(i).getMajor());
                preparedStatement.setString(4,students.get(i).getComment());
            }

            @Override
            public int getBatchSize() {
                return students.size();
            }
        }).length > 0;
    }

}
