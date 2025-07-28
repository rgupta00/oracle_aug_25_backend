package com.bankapp.dto;

import lombok.Data;

//DTO which can carry username and password
@Data
public class AuthRequest {
    private String username;
    private String password;
}