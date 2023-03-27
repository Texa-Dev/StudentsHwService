package com.example.javaexam.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Objects;

@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "homeworks")
public class Homework {
    //статус домашней работы (хотел добавить еще просроченную (не успел, работаю))
    public enum Status {CREATED, ASSIGNED, IN_PROGRESS, UNCHECKED, COMPLETE}

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
    @Column(nullable = false, columnDefinition = "int default 0")
    private int grade;
    @Column(nullable = false,
            columnDefinition = "int(1) default 0")
    private Status status;
    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_teacher_id"))
    @ToString.Exclude
    private Teacher teacher;
    @ManyToOne(cascade = CascadeType.ALL)
    @ToString.Exclude
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_student_id"))
    private Student student;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Homework homework = (Homework) o;
        return Objects.equals(id, homework.id) && Objects.equals(task, homework.task) && Objects.equals(assignmentDate, homework.assignmentDate) && Objects.equals(deadlineDate, homework.deadlineDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, task, assignmentDate, deadlineDate);
    }
}
