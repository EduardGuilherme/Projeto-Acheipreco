package br.com.acheipreco.acheiprecoApi.DTOs;

import br.com.acheipreco.acheiprecoApi.Enums.Tipodeusuario;

public record UserDTO(String nomeCompleto,String nomeEmpresa, String email, String senha, Tipodeusuario tipodeusuario) {
}
