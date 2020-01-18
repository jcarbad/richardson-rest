package com.jcarbad.richardsonrest.controllers.v1;

import com.jcarbad.richardsonrest.api.v1.model.CategoryDTO;
import com.jcarbad.richardsonrest.services.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories/")
public class CategoryController {

   private final CategoryService categoryService;

   public CategoryController(CategoryService categoryService) {
      this.categoryService = categoryService;
   }

   @GetMapping
   public List<CategoryDTO> getAllCategories() {
      return categoryService.getAllCategories();
   }

   @GetMapping("{name}")
   public ResponseEntity<CategoryDTO> getCategoryByName(@PathVariable String name) {
      return new ResponseEntity<>(categoryService.getCategoryByName(name), HttpStatus.OK);
   }
}
