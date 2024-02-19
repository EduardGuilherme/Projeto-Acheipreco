package br.com.acheipreco.acheiprecoApi.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name="empresa")
@Getter
@Setter
@NoArgsConstructor
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID empresaId;
    private String empresaNome;
    @Column(unique = true,length = 14,nullable = false)
    private  String empresaCnpj;

    public Company(String empresaNome, String empresaCnpj) {
        this.empresaNome = empresaNome;
        this.empresaCnpj = empresaCnpj;
    }
}
