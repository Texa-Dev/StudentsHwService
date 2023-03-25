package com.example.javaexam.services.data.db;

import com.example.javaexam.models.User;
import com.example.javaexam.service.UserService;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class UserServiceDbTest {
    @Autowired
    UserService userService;

    @Autowired
    User userExp;
    User userAct;
    @Autowired
    List<User> userList;

   /* @Test
    @Order(1)
    void save() {
        System.out.println(userExp);
        userAct = userService.save(userExp);
        assertEquals(userExp, userAct);
    }*/
}
