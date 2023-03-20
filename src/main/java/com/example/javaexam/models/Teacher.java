package com.example.javaexam.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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
    @OneToMany(mappedBy = "teacher")
    private List<Homework> homeworks;


}
