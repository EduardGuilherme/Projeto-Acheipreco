package com.example.NaoSeiONome.Services;

import com.example.NaoSeiONome.DTO.AdressDTO;
import com.example.NaoSeiONome.Model.Adress;
import com.example.NaoSeiONome.Repository.AdressRepository;
import com.example.NaoSeiONome.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
public class AdressService {

    @Autowired
    AdressRepository adressRepository;
    @Autowired
    UserRepository userRepository;

    public ResponseEntity<String> createAdress(AdressDTO adressDTO)
    {
        if(userRepository.findById(adressDTO.idUsuario()).isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        adressRepository.save(new Adress(
                userRepository.findById(adressDTO.idUsuario()).get(),
                adressDTO.adress(),
                adressDTO.cep(),
                adressDTO.complement()
        ));
     return ResponseEntity.ok("Endereço criado");
    }

    public ResponseEntity<List<Adress>> listAllAdress(){
        return ResponseEntity.ok(adressRepository.findAll());
    }

    public ResponseEntity<String> deleteAdress(String id){
        if(adressRepository.findById(id).isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        adressRepository.delete(adressRepository.findById(id).get());
        return ResponseEntity.ok("Endereço excluido com sucesso");
    }

    public ResponseEntity<String> changeAdress(AdressDTO adressDTO, String id){
        if(adressRepository.findById(id).isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        if(userRepository.findById(adressDTO.idUsuario()).isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        adressRepository.save(new Adress(
                adressRepository.findById(id).get().getId(),
                userRepository.findById(adressDTO.idUsuario()).get(),
                adressDTO.adress(),
                adressDTO.cep(),
                adressDTO.complement()
        ));
        return ResponseEntity.ok("Endereço alterado com sucesso");
    }
}
