package com.example.todo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.todo.dto.TodoDto;
import com.example.todo.entity.Todo;
import com.example.todo.repo.TodoRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class TodoService { 
    private final TodoRepository repository;

    public List<Todo> findTodos() {
        return repository.findAll();
    }
    
    public Long createTodo(TodoDto todoDto) {
        Todo todo = Todo.toEntity(todoDto);
        repository.save(todo);
        return todoDto.getTodoId();
    }

    public void deleteTodo(Long id) {
        repository.deleteById(id);
    }

    public void updateTodo(Long id,TodoDto todoDto) {
        Optional<Todo> todo = repository.findById(id);
        todo.ifPresent(a->{
            Todo tmp = todo.get();
            tmp.setContent(todoDto.getContent());
            tmp.setDueDate(todoDto.getDueDate());
            tmp.setStatus(todoDto.getStatus());
            repository.save(tmp);
        });
    }
}
