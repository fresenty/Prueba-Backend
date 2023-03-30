package com.fredy.pruebanexsys.service.impl;

import com.fredy.pruebanexsys.dto.response.ProductGetAllDto;
import com.fredy.pruebanexsys.dto.request.ProductRequestCloudDto;
import com.fredy.pruebanexsys.dto.request.ProductRequestInternalDto;
import com.fredy.pruebanexsys.dto.response.ProductResponseDto;
import com.fredy.pruebanexsys.mapper.ProductMapper;
import com.fredy.pruebanexsys.model.entity.ProductEntity;
import com.fredy.pruebanexsys.service.AbstractClient;
import com.fredy.pruebanexsys.service.CategoryService;
import com.fredy.pruebanexsys.service.ProductService;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl extends AbstractClient implements ProductService {

    private final ProductMapper productMapper;
    private final CategoryService categoryService;
    protected ProductServiceImpl(RestTemplate restTemplate, ProductMapper productMapper, CategoryService categoryService) {
        super(restTemplate);
        this.productMapper = productMapper;
        this.categoryService = categoryService;
    }

    @Override
    public List<ProductGetAllDto> getAllProducts(){
        String uri = baseUrl + "/products";
        ResponseEntity<ProductEntity[]> response = restTemplate.exchange(
                uri, HttpMethod.GET, null, ProductEntity[].class
        );
        if(response.getStatusCode().is2xxSuccessful()){
            return Arrays.stream(response.getBody()).map(product -> productMapper.productEntityToProductDto(product)).collect(Collectors.toList());
        }
        throw  new RuntimeException("there was an error");
    }

    @Override
    public ProductResponseDto saveProduct(ProductRequestInternalDto productRequestInternalDto){
        String uri = baseUrl + "/products";
        ProductRequestCloudDto requestDto = productMapper.productDtoToProductRequestDto(productRequestInternalDto);
        requestDto.setCategoryId(categoryService.randomCategoryId());
        requestDto.addImage(productRequestInternalDto.getImageUrl());
        ResponseEntity<ProductEntity> response = restTemplate.postForEntity(uri, requestDto, ProductEntity.class);
        if(response.getStatusCode().is2xxSuccessful()){
            return productMapper.productEntityToProductResponseDto(response.getBody());
        }
        throw new RuntimeException("There was an error");
    }
}
