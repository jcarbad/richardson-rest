package com.jcarbad.richardsonrest.services;

import com.jcarbad.richardsonrest.api.v1.model.CategoryDTO;

import java.util.List;

public interface CategoryService {
   List<CategoryDTO> getAllCategories();
   CategoryDTO getCategoryByName(String name);
}
