package com.ayudantec.crm.dto;

import com.ayudantec.crm.model.User;
import lombok.Data;

@Data
public class UserResponse {
    private Long id;
    private String nombre;
    private String email;
    private User.UserRole rol;
}