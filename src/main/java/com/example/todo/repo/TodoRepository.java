package com.example.todo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.todo.entity.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
}