package com.example.exam9.model;

import com.example.exam9.entity.Status;
import com.example.exam9.entity.Task;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static java.util.Objects.nonNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaskDTO {

    private Long id;
    private String name;
    private String createdTime;
    private String developer;
    private Status status;
    private Long developerId;

    public static TaskDTO of(Task task) {
        return TaskDTO.builder()
                .id(task.getId())
                .name(task.getName())
                .createdTime(task.getCreatedTime().toString())
                .status(task.getStatus())
                .developer(nonNull(task.getDeveloper()) ? task.getDeveloper().getName() : "")
                .developerId(nonNull(task.getDeveloper()) ? task.getDeveloper().getId() : null)
                .build();
    }
}
