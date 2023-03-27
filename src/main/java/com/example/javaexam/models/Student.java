package com.example.javaexam.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

//@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length = 50)
    private String surname;
    @Column(nullable = false, length = 50)
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;
    @Column(nullable = false) // Группа должна быть сущьностью но пока так
    private String st_group;
    @Column(nullable = false, columnDefinition = "double default 0.0")
    private double avgGrade;
    @OneToOne
    private User user;
    @OneToMany(mappedBy = "student")
    @ToString.Exclude
    private List<Homework> homeworks;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id) && Objects.equals(surname, student.surname) && Objects.equals(name, student.name) && Objects.equals(birthDate, student.birthDate) && Objects.equals(st_group, student.st_group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, surname, name, birthDate, st_group);
    }
}
