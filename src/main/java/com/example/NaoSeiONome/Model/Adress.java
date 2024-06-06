package com.example.NaoSeiONome.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "adress")
public class Adress {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @ManyToOne
    private User user;
    private String area;
    private String cep;
    private String complement;

    public Adress(User user, String area, String cep, String complement) {
        this.user = user;
        this.area = area;
        this.cep = cep;
        this.complement = complement;
    }
}
