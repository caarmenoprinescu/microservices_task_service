package com.carmenoprinescu.task_service.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "tasks")
@NoArgsConstructor
@Getter
@Setter
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Long userId;

    private boolean status;

    @Column(nullable = false)
    private String description;


    public Task(String name, String description, Long userId, boolean status) {
        this.name = name;
        this.description = description;
        this.userId = userId;
        this.status = status;


    }
}