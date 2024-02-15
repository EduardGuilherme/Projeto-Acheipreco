package br.com.acheipreco.acheiprecoApi.Model;

import br.com.acheipreco.acheiprecoApi.Enums.Tipodeusuario;
import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.UUID;

@EntityScan
@Table(name = "user")
public class User {
    private static final long SerialVersion = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String nomeCompleto;
    private String nomeEmpresa;
    private String senha;
    private String email;
    @Enumerated(EnumType.ORDINAL)
    private Tipodeusuario tipodeusuario;

    public User() {
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Colocando um comentario pos possivelmente vamos precisar desse bloco de código
        return null;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Tipodeusuario getTipodeusuario() {
        return tipodeusuario;
    }

    public void setTipodeusuario(Tipodeusuario tipodeusuario) {
        this.tipodeusuario = tipodeusuario;
    }
}
