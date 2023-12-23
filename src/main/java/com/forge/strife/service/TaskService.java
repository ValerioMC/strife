package com.forge.strife.service;


import com.forge.strife.model.Task;
import com.forge.strife.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(Long id) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        return optionalTask.orElse(null);
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public Task updateTask(Long id, Task updatedTask) {
        Optional<Task> optionalTask = taskRepository.findById(id);

        if (optionalTask.isPresent()) {
            Task existingTask = optionalTask.get();
            existingTask.setRequirement(updatedTask.getRequirement());
            existingTask.setDescription(updatedTask.getDescription());
            existingTask.setComponent(updatedTask.getComponent());
            existingTask.setWeight(updatedTask.getWeight());

            return taskRepository.save(existingTask);
        } else {
            return null;
        }
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
