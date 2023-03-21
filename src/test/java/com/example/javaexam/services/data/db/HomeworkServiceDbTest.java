package com.example.javaexam.services.data.db;

import com.example.javaexam.models.Homework;
import com.example.javaexam.service.data.HomeworkService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class HomeworkServiceDbTest {
    @Autowired
    HomeworkService homeworkService;

    @Autowired
    Homework homeworkExp;
    Homework homeworkAct;

    @Test
    public void save(){
        homeworkAct= homeworkService.save(homeworkExp);
        Assertions.assertEquals(homeworkExp,homeworkAct);
    }
}
