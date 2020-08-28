package com.chinalink.demo.FastDemo.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.chinalink.demo.FastDemo.entity.StudentMongo;

@Repository
public interface StudentRepositoryMongoDB extends MongoRepository<StudentMongo,String>{

}
