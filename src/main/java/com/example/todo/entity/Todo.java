package com.example.todo.entity;

import java.time.LocalDateTime;

import com.example.todo.dto.TodoDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Boolean status;

    @Column(length = 50, nullable = false)
    private String content;

    @Column(nullable = true)
    private LocalDateTime dueDate;

    public static Todo toEntity(TodoDto dto) {
        Todo todo = new Todo();
        todo.setId(dto.getTodoId());
        todo.setStatus(dto.getStatus());
        todo.setContent(dto.getContent());
        todo.setDueDate(dto.getDueDate());
        return todo;
    }
}
