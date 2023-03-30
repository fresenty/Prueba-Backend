package com.fredy.pruebanexsys.service;

import com.fredy.pruebanexsys.dto.response.CategoryGetAllDto;

import java.util.List;

public interface CategoryService {
    List<CategoryGetAllDto> getAllCategories();

    Long randomCategoryId();
}
