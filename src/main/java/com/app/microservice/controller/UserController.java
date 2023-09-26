package com.app.microservice.controller;

import com.app.microservice.model.User;
import com.app.microservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
@Validated
/**
 * User controller microservice deals with all CRUD operations regarding the @Entity users
 */
public class UserController {
    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping(path = "/")
    public String index(){
        return "Airfrance microservice";
    }

    /**
     * <p> Add a new user to the database </p>
     * @param user
     * @return
     */
    @PostMapping( path =  "/add", consumes = "application/json", produces = "application/json")
    public User add(@RequestBody User user)
    {
        return service.add(user);
    }

    /**
     * Update a user
     * @param user
     * @return
     */
    @PutMapping(path = "/update")
    public User update(@RequestBody User user)
    {
        return service.update(user);
    }

    /**
     * <p> Fetch a user given it identifier </p>
     * @param id
     * @return User | null
     */
    @GetMapping(path = "/get/{id}")
    public User get(@PathVariable long id ){
        return service.getUser(id);
    }

    /**
     * <p> Get the list of all available users in the database. </p>
     * @return List<User> | null
     */
    @GetMapping(path = "/users")
    public List<User> getUsers(){
        return service.getUsers();
    }

    @DeleteMapping(path = "/delete/{id}")
    public boolean delete(@PathVariable long id)
    {
        return service.delete(id);
    }
}
