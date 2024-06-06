package com.example.NaoSeiONome.Controller;

import com.example.NaoSeiONome.DTO.AdressDTO;
import com.example.NaoSeiONome.Services.AdressService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("adress")
public class AdressController {

    @Autowired
    AdressService adressService;

    @GetMapping("/list")
    public ResponseEntity listAll(){
        return adressService.listAllAdress();
    }

    @PostMapping("/create")
    public ResponseEntity create(@RequestBody @Valid AdressDTO adressDTO){
        return adressService.createAdress(adressDTO);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable String id){
        return adressService.deleteAdress(id);
    }

    @PutMapping("/change/{id}")
    public ResponseEntity change(@RequestBody @Valid AdressDTO adressDTO, @PathVariable String id){
        return adressService.changeAdress(adressDTO,id);
    }
}
