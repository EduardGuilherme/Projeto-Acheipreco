package br.com.acheipreco.acheiprecoApi.Controllers;

import br.com.acheipreco.acheiprecoApi.DTOs.AuthenticationDTO;
import br.com.acheipreco.acheiprecoApi.DTOs.TokenDTO;
import br.com.acheipreco.acheiprecoApi.DTOs.UserDTO;
import br.com.acheipreco.acheiprecoApi.Enums.Tipodeusuario;
import br.com.acheipreco.acheiprecoApi.Model.Users;
import br.com.acheipreco.acheiprecoApi.Repository.UserRepository;
import br.com.acheipreco.acheiprecoApi.Services.TokenServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class LoginController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenServices tokenServices;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO authenticationDTO){
        var usernamePassword = new UsernamePasswordAuthenticationToken(authenticationDTO.email(),authenticationDTO.senha());
        System.out.println(usernamePassword);
        var auth = this.authenticationManager.authenticate(usernamePassword);
        var token = tokenServices.generationToken((Users) auth.getPrincipal());
        return ResponseEntity.ok(new TokenDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid UserDTO userDTO){
        if(userRepository.findByEmail(userDTO.email()) != null){
            throw new IllegalArgumentException("USUARIO JÁ CRIADO");
        }
        String encryptedPassword = new BCryptPasswordEncoder().encode(userDTO.senha());
        if(userDTO.tipodeusuario().equals(Tipodeusuario.CLIENTE)){
            Users user = new Users(
                    userDTO.nomeCompleto(),
                    encryptedPassword,
                    userDTO.email(),
                    userDTO.tipodeusuario()
                    );
            this.userRepository.save(user);
        }else{
            Users user = new Users(
                    userDTO.nomeCompleto(),
                    encryptedPassword,
                    userDTO.email(),
                    userDTO.tipodeusuario()
            );
            this.userRepository.save(user);
        }
        return ResponseEntity.ok().build();
    }
}
