package com.example.NaoSeiONome.Controller;

import com.example.NaoSeiONome.DTO.CompanyDTO;
import com.example.NaoSeiONome.Model.Company;
import com.example.NaoSeiONome.Repository.CompanyRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("company")
public class CompanyController {

    @Autowired
    private CompanyRepository companyRepository;

    @GetMapping("/list")
    public ResponseEntity findAll(){
        return ResponseEntity.ok(companyRepository.findAll());
    }

    @PostMapping("/create")
    public ResponseEntity create(@RequestBody @Valid CompanyDTO companyDTO){
        Company company = new Company(companyDTO.nomeEmpresa(),companyDTO.empresaCNPJ());
        companyRepository.save(company);
        return ResponseEntity.ok().build();
    }
}
