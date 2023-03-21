package com.example.javaexam.service.data;

import com.example.javaexam.models.Teacher;

public interface TeacherService {
    Teacher save(Teacher teacherExp);

    Teacher findById(int id);
}
