package com.demo.authorizer.dao;

import java.util.List;

import com.demo.authorizer.entity.Task;

public interface TaskDAO extends GenericDAO<Task, Integer> {
    
    List<Task> findTasksByUserId(int userId);

}
