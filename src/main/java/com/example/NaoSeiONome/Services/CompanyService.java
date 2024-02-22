package com.example.NaoSeiONome.Services;

import com.example.NaoSeiONome.DTO.CompanyDTO;
import com.example.NaoSeiONome.Model.Company;
import com.example.NaoSeiONome.Model.User;
import com.example.NaoSeiONome.Model.UserRole;
import com.example.NaoSeiONome.Repository.CompanyRepository;
import com.example.NaoSeiONome.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentMap;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<String> createCompany(CompanyDTO companyDTO){
        if(companyRepository.findByCNPJ(companyDTO.CNPJ()) != null || userRepository.findById(companyDTO.idUser()) == null){
            return ResponseEntity.badRequest().build();
        }
        Optional<User> userOptional = userRepository.findById(companyDTO.idUser());
        Company company = new Company(
                userOptional.get(),
                companyDTO.companyName(),
                companyDTO.companyAdress(),
                companyDTO.CNPJ(),
                companyDTO.companyRole(),
                companyDTO.logo(),
                companyDTO.workTime(),
                companyDTO.hasDelivery()
                        );
        userOptional.get().setRole(UserRole.EMPRESA);
        userRepository.save(userOptional.get());
        companyRepository.save(company);
        return ResponseEntity.ok("Empresa criada");
    }

    public ResponseEntity<String> deleteCompany(String id){
        if(companyRepository.findById(id) != null) {
            Optional<Company> company = companyRepository.findById(id);
            companyRepository.delete(company.get());
            return ResponseEntity.ok("Empresa excluida");
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<String> changeCompany(CompanyDTO companyDTO, String id){
        if(companyRepository.findById(id) != null){
         Optional<Company> companyOptional = companyRepository.findById(id);
         Company newCompany = new Company(
                 companyOptional.get().getIdUser(),
                 companyDTO.companyName(),
                 companyDTO.companyAdress(),
                 companyOptional.get().getCNPJ(),
                 companyDTO.companyRole(),
                 companyDTO.logo(),
                 companyDTO.workTime(),
                 companyDTO.hasDelivery()
         );
         newCompany.setId(id);
         companyRepository.save(newCompany);
         return ResponseEntity.ok("Empresa atualizada");
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<List<Company>> listAllCompany(){
        return ResponseEntity.ok(companyRepository.findAll());
    }

}
