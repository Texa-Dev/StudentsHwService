package com.example.javaexam.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "homeworks")
public class Homework {
    public enum Status {CREATED, ASSIGNED, IN_PROGRESS, COMPLETE, UNCHECKED, CHECKED}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length = 50)
    private String task;
    @Column(nullable = false, length = 2048)
    private String text;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate assignmentDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate deadlineDate;
    @Column(nullable = false,
            columnDefinition = "int(1) default 0")
    private Status status;
    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_teacher_id"))
    private Teacher teacher;
    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_student_id"))
    private Student student;
}
