package com.example.javaexam.service.data;

import com.example.javaexam.models.Teacher;
import com.example.javaexam.models.User;

public interface TeacherService {
    Teacher save(Teacher teacherExp);

    Teacher findById(int id);

    Teacher findTeacherByUser(User byUsername);
}
