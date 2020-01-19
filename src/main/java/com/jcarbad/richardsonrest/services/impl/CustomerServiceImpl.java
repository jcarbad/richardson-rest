package com.jcarbad.richardsonrest.services.impl;

import com.jcarbad.richardsonrest.domain.Customer;
import com.jcarbad.richardsonrest.repositories.CustomerRepository;
import com.jcarbad.richardsonrest.services.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService
{
   private final CustomerRepository customerRepository;

   public CustomerServiceImpl(CustomerRepository customerRepository) {
      this.customerRepository = customerRepository;
   }

   @Override
   public List<Customer> getAllCustomers() {
      return customerRepository.findAll();
   }

   @Override
   public Customer findById(Long id) {
      return customerRepository.findById(id).orElse(null);
   }

   @Override
   public Customer create(Customer customer) {
      return customerRepository.save(customer);
   }

   @Override
   public Customer update(Long id, Customer customer) {
      customer.setId(id);
      return customerRepository.save(customer);
   }

   @Override
   public void delete(Long id) {
      Customer toDelete = findById(id);
      if (toDelete != null) {
         customerRepository.delete(toDelete);
      }
   }
}
