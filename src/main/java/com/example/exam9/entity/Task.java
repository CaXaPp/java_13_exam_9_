package com.example.exam9.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 4, max = 25, message = "Length must be > 4 and < 25")
    @Column(length = 25)
    private String name;

    private LocalDateTime createdTime;

    @ManyToOne
    @JoinColumn(name = "created_by")
    private User createdBy;

    @ManyToOne
    @JoinColumn(name = "developer_id")
    private User developer;

    @Enumerated(value = EnumType.STRING)
    @Column
    private Status status;

    @OneToMany(mappedBy = "task")
    private List<WorkLogs> workLogsList;
}
