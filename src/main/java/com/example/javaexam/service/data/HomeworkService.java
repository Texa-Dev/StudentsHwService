package com.example.javaexam.service.data;

import com.example.javaexam.models.Homework;

public interface HomeworkService {
    Homework save(Homework homeworkExp);

    Homework findById(int id);
}
