package com.example.NaoSeiONome.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="company")
@Getter
@Setter
@NoArgsConstructor
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @ManyToOne
    private User idUser;
    private String companyName;
    private String companyAdress;
    @Column(unique = true, length = 14, nullable = false)
    private String CNPJ;
    private String companyRole;
    private String logo;
    private String workTime;
    private Boolean hasDelivery;

    public Company(User idUser, String companyName, String companyAdress, String CNPJ, String companyRole, String logo, String workTime, Boolean hasDelivery) {
        this.idUser = idUser;
        this.companyName = companyName;
        this.companyAdress = companyAdress;
        this.CNPJ = CNPJ;
        this.companyRole = companyRole;
        this.logo = logo;
        this.workTime = workTime;
        this.hasDelivery = hasDelivery;
    }
}
