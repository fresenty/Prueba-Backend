package com.fredy.pruebanexsys.controller;

import com.fredy.pruebanexsys.dto.response.ProductGetAllDto;
import com.fredy.pruebanexsys.dto.request.ProductRequestInternalDto;
import com.fredy.pruebanexsys.dto.response.ProductResponseDto;
import com.fredy.pruebanexsys.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/nexsys/v1")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // Endpoint for getting all products
    @GetMapping("/products")
    public ResponseEntity<List<ProductGetAllDto>> getAllProduct(){
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    // Endpoint for saving a new product
    @PostMapping("/categories")
    public ResponseEntity<ProductResponseDto> saveProduct(@Valid @RequestBody ProductRequestInternalDto productRequestInternalDto){
        return new ResponseEntity<>(productService.saveProduct(productRequestInternalDto), HttpStatus.CREATED);
    }
}
