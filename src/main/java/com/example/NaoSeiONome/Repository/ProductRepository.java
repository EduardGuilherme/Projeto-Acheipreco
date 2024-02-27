package com.example.NaoSeiONome.Repository;

import com.example.NaoSeiONome.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {

}
