package br.com.acheipreco.acheiprecoApi.Controllers;

import br.com.acheipreco.acheiprecoApi.DTOs.CompanyDTO;
import br.com.acheipreco.acheiprecoApi.Model.Company;
import br.com.acheipreco.acheiprecoApi.Services.CompanyServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("company")
public class CompanyController {

    @Autowired
    private CompanyServices companyServices;

    @GetMapping("listAllCompany")
    public ResponseEntity findAllCompany(){
        return companyServices.findAllCompany();
    }

    @PostMapping("createCompany")
    public ResponseEntity createCompany(@RequestBody @Valid CompanyDTO companyDTO){
        Company company = new Company(
                companyDTO.empresaNome(),
                companyDTO.empresaCnpj()
        );
        return companyServices.createCompany(company);
    }

}
