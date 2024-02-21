package com.example.NaoSeiONome.DTO;

import com.example.NaoSeiONome.Model.UserRole;

public record RegisterDTO(String name, String login,String image, String password, UserRole role) {
}
