/**
 * Controller package
 */
package com.app.microservice.controller;

import com.app.microservice.model.User;
import com.app.microservice.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.Year;
import java.util.List;

@RestController
@RequestMapping("api/v1/user")
@Validated
/**
 * User controller microservice deals with all CRUD operations regarding the @Entity users
 */
public class UserController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping(path = "/")
    public String index(){
        //logger.info(RequestBody.);
        return " microservice";
    }

    /**
     * <p> Add a new user to the database </p>
     * @param user
     * @return
     */
    @PostMapping( path =  "/add", consumes = "application/json", produces = "application/json")
    public ResponseEntity add(@RequestBody User user)
    {
        if(!user.getResidence().equalsIgnoreCase("French")){
            return new ResponseEntity<>(
                    "It must be a French resident",
                    HttpStatus.BAD_REQUEST);
        }

        if( Period.between(user.getBirthday(), LocalDate.now()).getYears() < 18 ){
            return new ResponseEntity<>(
                    "It must be an adult.",
                    HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(service.add(user));
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
    public ResponseEntity get(@PathVariable long id){
        User u = service.getUser(id);
        if(u == null)
            return new ResponseEntity<>(
                "Sorry, this User was not found.",
                HttpStatus.BAD_REQUEST);
        return ResponseEntity.ok(u);
    }

    /**
     * <p> Get the list of all available users in the database. </p>
     * @return List<User> | null
     */
    @GetMapping(path = "/users")
    public List<User> getUsers(){

        return service.getUsers();
    }

    /**
     * Restful API Delete action for deleting a user identified by an identifier. </p>
     * @param id
     * @return ResponseEntity
     */
    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity delete(@PathVariable long id)
    {
        User u = service.getUser(id);
        if(u == null)
            return new ResponseEntity<>(
                    "Sorry, this User was not found.",
                    HttpStatus.BAD_REQUEST);
        return ResponseEntity.ok(service.delete(id));
    }
}
