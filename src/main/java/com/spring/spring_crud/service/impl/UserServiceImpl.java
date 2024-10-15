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

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(Long id) {
        return userRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid user id " + id));
    }

    @Override
    public void updateUser(Long id, User user) {
        // Check if the user exists
        userRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid user id " + id));

        user.setId(id); // Ensure the ID of the user being updated is set
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        // Check if the user exists before attempting to delete
        userRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid user id " + id));

        userRepository.deleteById(id); // Delete by ID instead of passing the user object
    }

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
