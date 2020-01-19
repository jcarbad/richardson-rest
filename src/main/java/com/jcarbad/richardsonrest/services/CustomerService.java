package com.jcarbad.richardsonrest.services;

import com.jcarbad.richardsonrest.domain.Customer;

import java.util.List;

public interface CustomerService {
   List<Customer> getAllCustomers();
   Customer findById(Long id);
}
