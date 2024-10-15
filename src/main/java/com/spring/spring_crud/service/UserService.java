package com.spring.spring_crud.service;

import com.spring.spring_crud.dto.UserDTO;
import com.spring.spring_crud.entity.User;

import java.util.List;

/**
 * Service interface for managing user-related operations.
 */
public interface UserService {

    /**
     * Adds a new user.
     * @param user The user entity to be added.
     */
    void addUser(User user);

    /**
     * Retrieves a list of all users.
     * @return A list of User entities.
     */
    List<User> getUsers();

    /**
     * Retrieves a user by their ID.
     * @param id The ID of the user to be retrieved.
     * @return The User entity if found.
     */
    User getUser(Long id);

    /**
     * Updates an existing user's details.
     * @param id The ID of the user to be updated.
     * @param user The updated user entity.
     */
    void updateUser(Long id, User user);

    /**
     * Deletes a user by their ID.
     * @param id The ID of the user to be deleted.
     */
    void deleteUser(Long id);

    /**
     * Updates the name of an existing user.
     * @param id The ID of the user whose name is to be updated.
     * @param userDTO The data transfer object containing the new name.
     */
    void updateName(Long id, UserDTO userDTO);
}
