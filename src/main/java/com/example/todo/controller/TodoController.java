package com.example.todo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.todo.dto.TodoDto;
import com.example.todo.service.TodoService;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Controller
public class TodoController {
    private final TodoService service;

    @GetMapping("/")
    public String todo(Model model) {
        model.addAttribute("todos", service.findTodos());
        return "todo";
    }
    
    @PostMapping("/new")
    public ResponseEntity<?> createTodo(@RequestBody TodoDto todoDto) {
        service.createTodo(todoDto);
        return new ResponseEntity<>("{}", HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTodo(@PathVariable("id") Long id) {
        service.deleteTodo(id);
        return new ResponseEntity<>("{}", HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> putMethodName(@PathVariable Long id, @RequestBody TodoDto todoDto) {
        service.updateTodo(id, todoDto);
        return new ResponseEntity<>("{}", HttpStatus.OK);
    }
}
