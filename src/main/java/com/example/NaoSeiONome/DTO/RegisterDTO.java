package com.example.NaoSeiONome.DTO;

import com.example.NaoSeiONome.Model.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {
}
