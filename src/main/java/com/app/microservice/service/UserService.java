package com.app.microservice.service;

import com.app.microservice.model.User;
import com.app.microservice.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User Service class
 * It is responsible for all User object manipulations (CURD operations)
 */
@Service
public class UserService {
    private final UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    /**
     * Get a User by a given ID
     *
     * @return
     */
    public User getUser(long id) {
        if (repository.findById(id).isPresent())
            return repository.findById(id).get();
        return null;
    }

    public User getUser(User user) {
        return getUser(user.getId());
    }

    /**
     * List all users
     *
     * @return
     */
    public List<User> getUsers() {
        return repository.findAll();
    }

    /**
     * Add a User to the Database
     *
     * @param user
     * @return
     */
    public User add(User user) {
        return repository.save(user);
    }

    /**
     * Delete user given by an Id
     *
     * @param user
     * @return true | false
     */
    public boolean delete(User user) {
        User u = getUser(user);
        if (u != null) {
            repository.delete(user);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Delete a user given its Id
     *
     * @param id
     * @return
     */
    public boolean delete(long id) {
        return delete(new User(id));
    }

    /**
     * Update a User object who has an already existing id
     *
     * @param user
     * @return
     */
    public User update(User user) {
        User oldUser = repository.findById(user.getId()).get();
        if (oldUser != null) {
            oldUser.setName(user.getName());
            oldUser.setBirthday(user.getBirthday());
            oldUser.setGender(user.getGender());
            oldUser.setResidence(user.getResidence());
            oldUser.setPhone(user.getPhone());
            return repository.save(oldUser);
        }
        return null;

    }
}
