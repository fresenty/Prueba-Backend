package com.fredy.pruebanexsys.mapper;

import com.fredy.pruebanexsys.dto.response.ProductGetAllDto;
import com.fredy.pruebanexsys.dto.request.ProductRequestCloudDto;
import com.fredy.pruebanexsys.dto.request.ProductRequestInternalDto;
import com.fredy.pruebanexsys.dto.response.ProductResponseDto;
import com.fredy.pruebanexsys.model.entity.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {
    ProductMapper productMapper = Mappers.getMapper(ProductMapper.class);

    @Mappings({
            @Mapping(source = "id", target = "pid"),
            @Mapping(source = "title", target = "name"),
            @Mapping(source = "price", target = "priceFinal")
    })
    ProductGetAllDto productEntityToProductDto(ProductEntity productEntity);

    @Mapping(source = "id", target = "pid")
    ProductResponseDto productEntityToProductResponseDto(ProductEntity productEntity);

    @Mappings({
            @Mapping(source = "name", target = "title"),
            @Mapping(source = "priceFinal", target = "price")
    })
    ProductRequestCloudDto productDtoToProductRequestDto(ProductRequestInternalDto productRequestInternalDto);
}
