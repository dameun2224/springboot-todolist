package com.example.todo.dto;

import java.time.LocalDateTime;

import com.example.todo.entity.Todo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TodoDto {
    private Long todoId;
    private Boolean status;
    private String content;
    private LocalDateTime dueDate;

    private TodoDto(Todo todo) {
        this.status = todo.getStatus();
        this.dueDate = todo.getDueDate();
        this.content = todo.getContent();
    }

    public TodoDto(LocalDateTime dueDate, String content) {
        this.status = false;
        this.dueDate = dueDate;
        this.content = content;
    }

    public static TodoDto toDto(Todo entity) {
        TodoDto todoDto = new TodoDto(entity);
        return todoDto;
    }
}
    

