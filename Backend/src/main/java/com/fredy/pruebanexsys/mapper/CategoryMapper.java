package com.fredy.pruebanexsys.mapper;

import com.fredy.pruebanexsys.dto.response.CategoryGetAllDto;
import com.fredy.pruebanexsys.model.entity.CategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryMapper {

    CategoryMapper categoryMapper = Mappers.getMapper(CategoryMapper.class);

    @Mappings({
            @Mapping(source = "id", target = "cid"),
            @Mapping(source = "name", target = "title")
    })
    CategoryGetAllDto categoryEntityToCategoryDto(CategoryEntity categoryEntity);
}
