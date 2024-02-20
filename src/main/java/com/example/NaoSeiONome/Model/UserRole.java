package com.example.NaoSeiONome.Model;

public enum UserRole {
    ADMIN("ADMIN"),
    EMPRESA("EMPRESA"),
    CLIENTE("CLIENTE");

    private String role;

    UserRole(String role){
        this.role = role;
    }

    public String getRole(){ return role;}
}
