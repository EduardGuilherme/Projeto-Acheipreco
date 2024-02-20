package com.example.NaoSeiONome.Model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="empresa")
@Getter
@Setter
@NoArgsConstructor
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String empresaId;
    private String empresaNome;
    @Column(unique = true, length = 14, nullable = false)
    private String empresaCnpj;

    public Company(String empresaNome, String empresaCnpj) {
        this.empresaNome = empresaNome;
        this.empresaCnpj = empresaCnpj;
    }
}
