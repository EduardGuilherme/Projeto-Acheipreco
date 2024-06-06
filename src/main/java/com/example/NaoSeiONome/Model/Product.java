package com.example.NaoSeiONome.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="product")
@Getter
@Setter
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @ManyToOne
    private Company idCompany;
    private String productName;
    private String productType;
    private String productImage;
    private Integer productQtd;
    @Column(scale = 2, precision = 10)
    private Float price;

    public Product(Company idCompany, String productName, String productType, String productImage, Integer productQtd, Float price) {
        this.idCompany = idCompany;
        this.productName = productName;
        this.productType = productType;
        this.productImage = productImage;
        this.productQtd = productQtd;
        this.price = price;
    }
}
