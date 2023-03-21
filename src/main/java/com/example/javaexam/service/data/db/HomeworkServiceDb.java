package com.example.javaexam.service.data.db;

import com.example.javaexam.models.Homework;
import com.example.javaexam.repositories.HomeworkRepository;
import com.example.javaexam.service.data.HomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.AccessType;
import org.springframework.stereotype.Service;

@Service
public class HomeworkServiceDb implements HomeworkService {
    @Autowired
    HomeworkRepository homeworkRepository;
    @Override
    public Homework save(Homework homeworkExp) {
        return homeworkRepository.save(homeworkExp);
    }

    @Override
    public Homework findById(int id) {
        return homeworkRepository.findById(id).orElse(null);
    }
}
