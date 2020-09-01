package com.mqslll.todo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.mqslll.todo.entity.ToDoDetail;

@Repository
public interface ToDoRepository extends MongoRepository<ToDoDetail,String>{

}
