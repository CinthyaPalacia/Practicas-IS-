package com.practica1.main;

import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, Integer>
{
    Task findTaskById(final int Id);
    void deleteById(final int Id);
}
