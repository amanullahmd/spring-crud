package com.spring.spring_crud.service;

import com.spring.spring_crud.dto.UserDTO;
import com.spring.spring_crud.entity.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    List<User> getUsers();
    User getUser(Long id);

    void updateUser(Long id, User user);

    void deleteUser(Long id);

    void updateName(Long id, UserDTO userDTO);
}
