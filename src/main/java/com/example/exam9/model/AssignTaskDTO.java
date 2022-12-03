package com.example.exam9.model;

import com.example.exam9.entity.Status;
import com.example.exam9.entity.Task;

import static java.util.Objects.nonNull;

public class AssignTaskDTO {

    private Long id;
    private String name;
    private String createdTime;
    private Long developerId;
    private Status status;

    public static TaskDTO of(Task task) {
        return TaskDTO.builder()
                .id(task.getId())
                .name(task.getName())
                .createdTime(task.getCreatedTime().toString())
                .status(task.getStatus())
                .developer(nonNull(task.getDeveloper()) ? task.getDeveloper().getName() : "")
                .build();
    }
}
