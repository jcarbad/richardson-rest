package com.jcarbad.richardsonrest.bootstrap;

import com.jcarbad.richardsonrest.domain.Category;
import com.jcarbad.richardsonrest.domain.Customer;
import com.jcarbad.richardsonrest.repositories.CategoryRepository;
import com.jcarbad.richardsonrest.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
public class Bootstrap implements CommandLineRunner {

   private CategoryRepository categoryRepository;
   private CustomerRepository customerRepository;

   public Bootstrap(CategoryRepository categoryRepository, CustomerRepository customerRepository) {
      this.categoryRepository = categoryRepository;
      this.customerRepository = customerRepository;
   }

   @Override
   public void run(String... args) throws Exception {
      Stream.of(
            Category.builder().name("Fruits").build(),
            Category.builder().name("Dried").build(),
            Category.builder().name("Fresh").build(),
            Category.builder().name("Exotic").build(),
            Category.builder().name("Nuts").build()
      ).forEach(categoryRepository::save);

      System.out.println("Loaded Category data..." + categoryRepository.count() + " categories saved.");

      Stream.of(
            Customer.builder().firstName("Joe").lastName("Doe").build(),
            Customer.builder().firstName("Jane").lastName("Smith").build(),
            Customer.builder().firstName("John").lastName("Smith").build(),
            Customer.builder().firstName("Bob").lastName("Doe").build(),
            Customer.builder().firstName("Jack").lastName("Richardson").build()
      ).forEach(customerRepository::save);

      System.out.println("Loaded Customer data..." + customerRepository.count() + " customers saved.");
   }
}
