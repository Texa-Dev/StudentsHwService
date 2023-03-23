package com.example.javaexam.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name="teachers")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    @Column(nullable = false, length = 50)
    private String surname;
    @Column(nullable = false, length = 50)
    private String name;
    @OneToOne
    private User user;
    @OneToMany(mappedBy = "teacher")
    private List<Homework> homeworks;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(id, teacher.id) && Objects.equals(surname, teacher.surname) && Objects.equals(name, teacher.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, surname, name);
    }
}
