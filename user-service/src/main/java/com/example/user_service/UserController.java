package com.example.user_service;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import com.example.user_service.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    Map<Integer, String> users = new HashMap<>();

    // POST /users
    // Example request body:
    // {
    //   "name": "Alice",
    //   "id": 1234
    // }

    @PostMapping
    public User addUser(@RequestBody User user) {
        users.put(user.getId(),user.getName());
        return user;
    }


    // GET /users
    // Example response:
    // [
    //   {
    //     "name": "Alice",
    //     "id": 1234
    //   },     
    //   {
    //     "name": "Bob",
    //     "id": 5678                       
    //   }
    // ]

    

    @GetMapping
    public List<User> getUsers() {
        List<User> userList = new ArrayList<>();
        for (Map.Entry<Integer, String> entry : users.entrySet()){
            userList.add(new User(entry.getValue(), entry.getKey()));
        }
        return userList;
    }

    @GetMapping("/{id}")
    public String getUserNameById(@PathVariable int id) {
        String name = users.get(id);
        if (name != null) {
            return name;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
    }
}

