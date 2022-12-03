package com.example.exam9.service;

import com.example.exam9.entity.Task;
import com.example.exam9.entity.User;
import com.example.exam9.entity.WorkLogs;
import com.example.exam9.repository.WorkLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkLogService {

    private final WorkLogRepository repository;

    public WorkLogs addWorkLog(Task task, String time, String description, User principal){
        WorkLogs workLogs = new WorkLogs();
        workLogs.setCreatedTime(LocalDateTime.now());
        workLogs.setTime(time);
        workLogs.setDeveloper(principal);
        workLogs.setDescription(description);
        workLogs.setTask(task);
        return repository.save(workLogs);
    }
}
