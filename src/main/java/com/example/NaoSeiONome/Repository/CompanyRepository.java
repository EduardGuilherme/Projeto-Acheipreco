package com.example.NaoSeiONome.Repository;

import com.example.NaoSeiONome.Model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, String> {
}
