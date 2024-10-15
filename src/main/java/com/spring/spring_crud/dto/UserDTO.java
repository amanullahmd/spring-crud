package com.spring.spring_crud.dto;

import lombok.Data;

/**
 * Data Transfer Object (DTO) for transferring user data.
 * Used for updating specific fields like the user's name.
 */
@Data
public class UserDTO {
    /**
     * The name of the user.
     */
    private String name;
}
