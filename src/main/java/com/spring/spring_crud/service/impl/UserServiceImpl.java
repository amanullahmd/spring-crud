package com.spring.spring_crud.service.impl;

import com.spring.spring_crud.dto.UserDTO;
import com.spring.spring_crud.entity.User;
import com.spring.spring_crud.repository.UserRepository;
import com.spring.spring_crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

/**
 * Service implementation for managing user-related operations.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * Adds a new user to the repository.
     * @param user The user to be added.
     */
    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    /**
     * Retrieves a list of all users.
     * @return A list of User entities.
     */
    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    /**
     * Retrieves a user by their ID.
     * @param id The ID of the user to be retrieved.
     * @return The User entity if found.
     * @throws ResponseStatusException if the user is not found.
     */
    @Override
    public User getUser(Long id) {
        return userRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid user id " + id));
    }

    /**
     * Updates the details of an existing user.
     * @param id The ID of the user to be updated.
     * @param user The updated user details.
     * @throws ResponseStatusException if the user is not found.
     */
    @Override
    public void updateUser(Long id, User user) {
        // Check if the user exists
        userRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid user id " + id));

        user.setId(id); // Ensure the ID of the user being updated is set
        userRepository.save(user);
    }

    /**
     * Deletes a user by their ID.
     * @param id The ID of the user to be deleted.
     * @throws ResponseStatusException if the user is not found.
     */
    @Override
    public void deleteUser(Long id) {
        // Check if the user exists before attempting to delete
        userRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid user id " + id));

        userRepository.deleteById(id); // Delete by ID instead of passing the user object
    }

    /**
     * Updates the name of an existing user.
     * @param id The ID of the user whose name is to be updated.
     * @param userDTO The data transfer object containing the new name.
     * @throws ResponseStatusException if the user is not found.
     */
    @Override
    public void updateName(Long id, UserDTO userDTO) {
        // Fetch the existing user before updating
        User user = userRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid user id " + id));

        // Update the name with the value from the DTO
        user.setName(userDTO.getName());

        // Save the updated user back to the repository
        userRepository.save(user);
    }
}
