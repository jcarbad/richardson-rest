package com.jcarbad.richardsonrest.bootstrap;

import com.jcarbad.richardsonrest.domain.Category;
import com.jcarbad.richardsonrest.repositories.CategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
public class Bootstrap implements CommandLineRunner {

   private CategoryRepository categoryRepository;

   public Bootstrap(CategoryRepository categoryRepository) {
      this.categoryRepository = categoryRepository;
   }

   @Override
   public void run(String... args) throws Exception {
      Stream.of(
            Category.builder().name("Fruits").build(),
            Category.builder().name("Dried").build(),
            Category.builder().name("Fresh").build(),
            Category.builder().name("Exotic").build(),
            Category.builder().name("Nuts").build()
      ).forEach(cat ->
            categoryRepository.save(cat)
      );

      System.out.println("Loaded Category data..." + categoryRepository.count() + " categories saved.");

   }
}
