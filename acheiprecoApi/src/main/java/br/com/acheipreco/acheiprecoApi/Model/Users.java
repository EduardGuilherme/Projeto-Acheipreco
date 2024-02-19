package br.com.acheipreco.acheiprecoApi.Model;

import br.com.acheipreco.acheiprecoApi.Enums.Tipodeusuario;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "users")
public class Users implements UserDetails {
    private static final long SerialVersion = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String nomeCompleto;
    private String senha;
    private String email;
    private Tipodeusuario tipodeusuario;


    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(this.tipodeusuario == Tipodeusuario.EMPRESA){
            return List.of(new SimpleGrantedAuthority("EMPRESA"));
        }else if(this.tipodeusuario == Tipodeusuario.CLIENTE){
            return List.of(new SimpleGrantedAuthority("CLIENTE"));
        }else{
            return List.of(new SimpleGrantedAuthority("ADMIN"),
                    new SimpleGrantedAuthority("EMPRESA"),
                    new SimpleGrantedAuthority("CLIENTE"));
        }
    }

    public Users(String nomeCompleto, String senha, String email, Tipodeusuario tipodeusuario) {
        this.nomeCompleto = nomeCompleto;
        this.senha = senha;
        this.email = email;
        this.tipodeusuario = tipodeusuario;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


}
