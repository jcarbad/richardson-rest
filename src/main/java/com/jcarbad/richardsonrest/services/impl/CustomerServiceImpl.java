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

   public CustomerServiceImpl(CustomerRepository customerRepository)
   {
      this.customerRepository = customerRepository;
   }

   @Override
   public List<Customer> getAllCustomers()
   {
      return customerRepository.findAll();
   }

   @Override
   public Customer findById(Long id)
   {
      return customerRepository.findById(id).orElse(null);
   }
}
