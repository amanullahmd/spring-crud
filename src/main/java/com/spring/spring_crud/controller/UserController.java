package com.spring.spring_crud.controller;

import com.spring.spring_crud.dto.UserDTO;
import com.spring.spring_crud.entity.User;
import com.spring.spring_crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public String addUser(@RequestBody User user) {
        userService.addUser(user);
        return "success add user";
    }

    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/get")
    public User getUser(@RequestParam Long id) {
        return userService.getUser(id); // Fix: Call getUser method instead of getUsers
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateUser(@PathVariable Long id, @RequestBody User user){
        userService.updateUser(id, user);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete/{id}") // Define the delete endpoint
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id); // Call the delete method from userService
        return ResponseEntity.noContent().build(); // Return 204 No Content
    }

    @PatchMapping("/update-name/{id}")
    public ResponseEntity<Void> updateName(@PathVariable Long id, @RequestBody UserDTO userDTO){
        userService.updateName(id, userDTO);
        return  ResponseEntity.noContent().build();
    }

}
