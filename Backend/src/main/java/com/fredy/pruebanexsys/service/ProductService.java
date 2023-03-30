package com.fredy.pruebanexsys.service;

import com.fredy.pruebanexsys.dto.response.ProductGetAllDto;
import com.fredy.pruebanexsys.dto.request.ProductRequestInternalDto;
import com.fredy.pruebanexsys.dto.response.ProductResponseDto;

import java.util.List;

public interface ProductService {
    List<ProductGetAllDto> getAllProducts();

    ProductResponseDto saveProduct(ProductRequestInternalDto productRequestInternalDto);
}
