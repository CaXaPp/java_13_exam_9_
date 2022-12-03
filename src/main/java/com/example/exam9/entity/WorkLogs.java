package com.example.exam9.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "work_logs")
@Getter
@Setter
public class WorkLogs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column
    private String time;

    private LocalDateTime createdTime;

    @NotBlank
    @Column
    private String description;

    @ManyToOne
    @JoinColumn(name = "developer_id")
    private User developer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_id")
    private Task task;

}
