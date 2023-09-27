package com.app.microservice;

import com.app.microservice.model.User;
import com.app.microservice.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

/**
 * Testing the standalone User Service
 */
@SpringBootTest
public class UserServiceTests {
    @Autowired
    private UserService service;

    @Test
    public void testAddUser()  throws Exception {
        User u = new User("Simon", LocalDate.of(2000, 1, 1), "French");
        assert service.add(u).getId() != 0;
        User u1 = new User("Merou", LocalDate.of(2000, 1, 1), "French");
        assert service.add(u1).getId() != 0;
        // Validator checks
        // uncomment this line to check the validators
        //User u2 = new User("Merou");
        //assert service.add(u2).getId() != 0;



    }

    @Test
    public void listUsers(){
        assert !service.getUsers().isEmpty();
        for( User tmp : service.getUsers()){
            System.out.println(tmp);
        }

    }

    @Test
    public void deleteUser(){
        User u = new User(1);
        assert service.delete(u) == true;

    }

    @Test
    public void updateUser(){
        User u = new User(2);
        u.setName("Me");
        u.setResidence("USA");
        assert service.update(u) != null;


    }
    @Test
    public void getUser(){

        User u = service.getUser(2);
        assert u != null;
        System.out.println("--------------------------Get User ---------------------");
        System.out.println(u);
        Assertions.assertEquals(u.getName(), "Me");
        Assertions.assertEquals(u.getResidence(), "USA");

    }




}
