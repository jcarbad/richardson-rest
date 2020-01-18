package com.jcarbad.richardsonrest.services.impl;

import com.jcarbad.richardsonrest.api.v1.mapper.CategoryMapper;
import com.jcarbad.richardsonrest.api.v1.model.CategoryDTO;
import com.jcarbad.richardsonrest.repositories.CategoryRepository;
import com.jcarbad.richardsonrest.services.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

   private final CategoryMapper categoryMapper;
   private final CategoryRepository categoryRepository;

   public CategoryServiceImpl(CategoryMapper categoryMapper, CategoryRepository categoryRepository) {
      this.categoryMapper = categoryMapper;
      this.categoryRepository = categoryRepository;
   }

   @Override
   public List<CategoryDTO> getAllCategories() {
      return categoryRepository.findAll().stream()
            .map(categoryMapper::getDtoFrom)
            .collect(Collectors.toList());
   }

   @Override
   public CategoryDTO getCategoryByName(String name) {
      return categoryMapper.getDtoFrom(categoryRepository.findByName(name));
   }
}
