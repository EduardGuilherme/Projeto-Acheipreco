package com.example.NaoSeiONome.DTO;

import java.math.BigDecimal;

public record ProductDTO(String idCompany, String name, String type, String image, Integer stack, BigDecimal price) {
}
