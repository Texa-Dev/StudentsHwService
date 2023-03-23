package com.example.javaexam.models;

import jakarta.persistence.*;
import lombok.*;

@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@ToString
@EqualsAndHashCode
@Table(name = "users")
public class User {
    public enum Status {CREATED, ACTIVE, BLOCKED}
    public enum Role {ADMIN, TEACHER, STUDENT}
    {
        status=Status.CREATED;
        role=Role.TEACHER;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private Integer id;
    @Column(nullable = false, unique = true)
    @NonNull
    private String username;
    @Column(nullable = false)
    @NonNull
    private String password;
    @Column(nullable = false, unique = true)
    @NonNull
    private String email;
    @Column(nullable = false,
            columnDefinition = "int(1) default 2"
    )
    private Status status;
    @Column(nullable = false,
            columnDefinition = "int(1) default 0"
    )
    private Role role;
}