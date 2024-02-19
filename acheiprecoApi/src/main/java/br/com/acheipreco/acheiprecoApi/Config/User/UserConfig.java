package br.com.acheipreco.acheiprecoApi.Config.User;

import br.com.acheipreco.acheiprecoApi.Controllers.LoginController;
import br.com.acheipreco.acheiprecoApi.DTOs.UserDTO;
import br.com.acheipreco.acheiprecoApi.Enums.Tipodeusuario;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*@Configuration
public class UserConfig {
    //@Bean
    CommandLineRunner commandLineRunner(LoginController loginController){
        return args -> {
            UserDTO userDTO = new UserDTO(
                    "eduTeste",
                    "edu@edu.com",
                    "1234",
                    Tipodeusuario.ADMIN
            );
            loginController.register(userDTO);
        };
    }
}*/
