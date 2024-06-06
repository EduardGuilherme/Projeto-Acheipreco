package com.example.NaoSeiONome.Controller;
import com.example.NaoSeiONome.DTO.CompanyDTO;
import com.example.NaoSeiONome.DTO.ProductDTO;
import com.example.NaoSeiONome.Model.Product;
import com.example.NaoSeiONome.Repository.CompanyRepository;
import com.example.NaoSeiONome.Services.CompanyService;
package com.example.NaoSeiONome.Controller;
import com.example.NaoSeiONome.DTO.ProductDTO;
import com.example.NaoSeiONome.Services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/list")
    public ResponseEntity findAll(){
        return productService.listAllProduct();
    }

    @PostMapping("/create")
    public ResponseEntity create(@RequestBody @Valid ProductDTO productDTO){
        return productService.createProduct(productDTO);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable String id){
        return productService.deleteProduct(id);
    }

    @PutMapping("/change/{id}")
    public ResponseEntity change(@RequestBody @Valid ProductDTO productDTO, @PathVariable String id){
        return productService.changeProduct(productDTO,id);
    }
}
