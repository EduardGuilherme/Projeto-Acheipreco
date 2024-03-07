package com.example.NaoSeiONome.Services;

import com.example.NaoSeiONome.DTO.ProductDTO;
import com.example.NaoSeiONome.Model.Company;
import com.example.NaoSeiONome.Model.Product;
import com.example.NaoSeiONome.Repository.CompanyRepository;
import com.example.NaoSeiONome.Repository.ProductRepository;
import com.example.NaoSeiONome.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CompanyRepository companyRepository;

    public ResponseEntity<String> createProduct(ProductDTO productDTO){
        if(companyRepository.findById(productDTO.idCompany()).isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        Optional<Company> company = companyRepository.findById(productDTO.idCompany());
        Product product = new Product(
                company.get(),
                productDTO.name(),
                productDTO.type(),
                productDTO.image(),
                productDTO.stack(),
                ArredondarValor(productDTO.price())
        );
        productRepository.save(product);
        return ResponseEntity.ok("Produto criado com sucesso");
    }

    public ResponseEntity<List<Product>> listAllProduct(){
        return ResponseEntity.ok(productRepository.findAll());
    }

    public ResponseEntity<String> deleteProduct(String id){
        if(productRepository.findById(id).isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        Optional<Product> product = productRepository.findById(id);
        productRepository.delete(product.get());
        return ResponseEntity.ok("Produto Deletado com sucesso");
    }

    public ResponseEntity<String> changeProduct(ProductDTO productDTO, String id){
        if(productRepository.findById(id) == null || companyRepository.findById(productDTO.idCompany()) == null){
            return ResponseEntity.badRequest().build();
        }
        Optional<Company> company = companyRepository.findById(productDTO.idCompany());
        Optional<Product> product = productRepository.findById(id);
        Product newProduct = new Product(
                company.get(),
                productDTO.name(),
                productDTO.type(),
                productDTO.image(),
                productDTO.stack(),
                ArredondarValor(productDTO.price())
        );
        newProduct.setId(product.get().getId());
        productRepository.save(newProduct);
        return ResponseEntity.ok("Produto Alterado com sucesso");
    }

    private Float ArredondarValor(BigDecimal valor){
        return valor.setScale(2, RoundingMode.DOWN).floatValue();
    }
}