package com.kamrul.Todo.controller;
//Communicates with the model

import com.kamrul.Todo.model.TodoItem;
import com.kamrul.Todo.repo.TodoRepo;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/todo") //for postman
public class TodoController {

    @Autowired
    private TodoRepo todoRepo;


    @GetMapping
    public List<TodoItem> findAll() {
        return todoRepo.findAll();
    }

    @PostMapping
    public TodoItem save(@Valid @NotNull @RequestBody TodoItem todoItem) {
        return todoRepo.save(todoItem);
    }

    @PutMapping //for updating data
    public TodoItem update(@Valid @NotNull @RequestBody TodoItem todoItem) {
        return todoRepo.save(todoItem); //sends the ids as well which updates data instead of saving new ones them
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) {
        todoRepo.deleteById(id);
    }

}
