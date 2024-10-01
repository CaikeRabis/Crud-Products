package com.example.crud.controllers;

import com.example.crud.RequestDTO.RequestProductDTO;
import com.example.crud.domain.product.Product;
import com.example.crud.repositories.ProductRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    ProductRepository repository;

    @Operation(description = "Get all products")
    @GetMapping
    public ResponseEntity getAllProducts() {
        var allProducts = repository.findAll();
        return ResponseEntity.ok(allProducts);
    }

    @Operation(description = "Get one product by id")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Product found"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "Product not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity getOneProduct(@PathVariable String id) {
        Optional<Product> optionalProduct = repository.findById(id);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            return ResponseEntity.ok(product);
        }
        return ResponseEntity.notFound().build();
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product added"),
            @ApiResponse(responseCode = "400", description = "Invalid data")
    })
    @Operation(description = "Add a product")
    @PostMapping
    public ResponseEntity addProduct(@RequestBody @Validated RequestProductDTO data) {
        Product product = new Product(data);
        repository.save(product);
        return ResponseEntity.ok().build();
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product updated"),
            @ApiResponse(responseCode = "404", description = "Product not found")
    })
    @Operation(description = "Update a product")
    @PutMapping
    @Transactional
    public ResponseEntity updateProduct(@RequestBody RequestProductDTO data) {
        Optional<Product> optionalProduct = repository.findById(data.id());
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            product.setName(data.name());
            product.setPrice_in_cents(data.price_in_cents());
            return ResponseEntity.ok().body(product);
        }
        return ResponseEntity.notFound().build();
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Product deleted"),
            @ApiResponse(responseCode = "404", description = "Product not found")
    })
    @Operation(description = "Delete a product by id")
    @DeleteMapping("/{id}")
    public ResponseEntity deleteProductTest (@PathVariable String id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    /*
    #Deletando pelo corpo da requisição
    @DeleteMapping
    public ResponseEntity deleteProduct (@RequestBody RequestProductDTO data) {
        Optional<Product> optionalProduct = repository.findById(data.id());
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            repository.delete(product);
            return ResponseEntity.ok("Deletado");
        }
        return ResponseEntity.notFound().build();
    }*/


}
