package com.spring.spring_crud.controller;

import com.spring.spring_crud.dto.UserDTO;
import com.spring.spring_crud.entity.User;
import com.spring.spring_crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for handling CRUD operations for User entities.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Adds a new user to the system.
     *
     * @param user The user entity containing the user details.
     * @return A message indicating the success of the operation.
     */
    @PostMapping("/add")
    public String addUser(@RequestBody User user) {
        userService.addUser(user);
        return "success add user";
    }

    /**
     * Retrieves all users in the system.
     *
     * @return A list of User entities.
     */
    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }

    /**
     * Retrieves a specific user by their ID.
     *
     * @param id The ID of the user to retrieve.
     * @return The User entity if found.
     */
    @GetMapping("/get")
    public User getUser(@RequestParam Long id) {
        return userService.getUser(id); // Fix: Call getUser method instead of getUsers
    }

    /**
     * Updates an existing user.
     *
     * @param id   The ID of the user to update.
     * @param user The updated user details.
     * @return A ResponseEntity indicating no content (204) if the update was successful.
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateUser(@PathVariable Long id, @RequestBody User user) {
        userService.updateUser(id, user);
        return ResponseEntity.noContent().build();
    }

    /**
     * Deletes a user by their ID.
     *
     * @param id The ID of the user to delete.
     * @return A ResponseEntity indicating no content (204) if the deletion was successful.
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id); // Call the delete method from userService
        return ResponseEntity.noContent().build(); // Return 204 No Content
    }

    /**
     * Updates the name of an existing user.
     *
     * @param id      The ID of the user whose name is to be updated.
     * @param userDTO The DTO containing the new name.
     * @return A ResponseEntity indicating no content (204) if the update was successful.
     */
    @PatchMapping("/update-name/{id}")
    public ResponseEntity<Void> updateName(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        userService.updateName(id, userDTO);
        return ResponseEntity.noContent().build();
    }

}
