package br.com.acheipreco.acheiprecoApi.Services;

import br.com.acheipreco.acheiprecoApi.DTOs.CompanyDTO;
import br.com.acheipreco.acheiprecoApi.Model.Company;
import br.com.acheipreco.acheiprecoApi.Repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class CompanyServices {

    @Autowired
    private CompanyRepository companyRepository;

    public ResponseEntity findAllCompany(){
        return ResponseEntity.ok(companyRepository.findAll());
    }

    public ResponseEntity createCompany(Company company){
        if(companyRepository.findByEmpresaCnpj(company.getEmpresaCnpj()) != null){
            throw new IllegalArgumentException("Empresa com CNPJ ja existente");
        }
        companyRepository.save(company);
        return ResponseEntity.ok("Empresa Criada com sucesso");
    }

}
