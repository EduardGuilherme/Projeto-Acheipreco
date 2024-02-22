package com.example.NaoSeiONome.DTO;

import com.example.NaoSeiONome.Model.User;
import jakarta.persistence.Column;

public record CompanyDTO(String idUser,
        String companyName,
        String companyAdress,
        String CNPJ,
        String companyRole,
        String logo,
        String workTime,
        Boolean hasDelivery) {
}
