package com.example.studentapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class TaskModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "deadline")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date deadline;

    @Column(name = "description")
    private String description;

    @Column(name = "color")
    private String color;


    @Column(name = "creation_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date creationDate;


    @ManyToOne
    @JoinColumn(name = "studentModel_id")
    private StudentModel studentModel;
}
