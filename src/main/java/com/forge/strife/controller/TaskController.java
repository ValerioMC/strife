package com.forge.strife.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.forge.strife.common.BaseEntityJsonView;
import com.forge.strife.model.Task;
import com.forge.strife.service.TaskService;
import com.forge.strife.to.TaskRecordGroup;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.forge.strife.mapper.TaskMapper.TASK_MAPPER;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/tasks")
public class TaskController {

    private final TaskService taskService;

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> tasks = taskService.getAllTasks();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        Task task = taskService.getTaskById(id);
        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    @JsonView(BaseEntityJsonView.Partial.class)
    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody TaskRecordGroup.TaskRequest task) {
        Task createdTask = taskService.createTask(TASK_MAPPER.recordToEntity(task));
        return new ResponseEntity<>(createdTask, HttpStatus.CREATED);
    }


    @JsonView(BaseEntityJsonView.Partial.class)
    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody TaskRecordGroup.TaskRequest task) {
        Task updatedTask = taskService.updateTask(id, TASK_MAPPER.recordToEntity(task));
        return new ResponseEntity<>(updatedTask, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}