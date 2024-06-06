package com.example.NaoSeiONome.Controller;

import com.example.NaoSeiONome.DTO.CompanyDTO;
import com.example.NaoSeiONome.Model.Company;
import com.example.NaoSeiONome.Repository.CompanyRepository;
import com.example.NaoSeiONome.Services.CompanyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @GetMapping("/list")
    public ResponseEntity findAll(){
        return companyService.listAllCompany();
    }

    @PostMapping("/create")
    public ResponseEntity create(@RequestBody @Valid CompanyDTO companyDTO){
        return companyService.createCompany(companyDTO);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable String id){
        return companyService.deleteCompany(id);
    }

    @PutMapping("/change/{id}")
    public ResponseEntity change(@RequestBody @Valid CompanyDTO companyDTO, @PathVariable String id){
        return companyService.changeCompany(companyDTO, id);
    }
}
