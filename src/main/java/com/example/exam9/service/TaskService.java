package com.example.exam9.service;

import com.example.exam9.entity.Status;
import com.example.exam9.entity.Task;
import com.example.exam9.entity.User;
import com.example.exam9.model.AddTaskDTO;
import com.example.exam9.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository repository;

    public List<Task> findAll() {
        return repository.findAll();
    }

    public Task create(AddTaskDTO dto, User principal){
        Task task = new Task();
        task.setCreatedTime(dto.getCreatedTime());
        task.setName(dto.getName());
        task.setCreatedBy(principal);
        task.setStatus(Status.CREATED);
        return repository.save(task);
    }

    public Task assignDeveloper(Task task, User developer) {
        task.setDeveloper(developer);
        return repository.save(task);
    }

    public Task edit(Task task, String name, Status status) {
        task.setName(name);
        task.setStatus(status);
        return repository.save(task);
    }
}
