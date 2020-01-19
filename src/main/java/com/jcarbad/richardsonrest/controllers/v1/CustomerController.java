package com.jcarbad.richardsonrest.controllers.v1;

import com.jcarbad.richardsonrest.api.v1.mapper.CustomerMapper;
import com.jcarbad.richardsonrest.api.v1.model.CustomerDTO;
import com.jcarbad.richardsonrest.domain.Customer;
import com.jcarbad.richardsonrest.services.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

   private final CustomerMapper customerMapper;
   private final CustomerService customerService;

   public CustomerController(CustomerMapper customerMapper, CustomerService customerService) {
      this.customerMapper = customerMapper;
      this.customerService = customerService;
   }

   @GetMapping({"", "/"})
   public List<CustomerDTO> getAllCustomers(){
       return customerService.getAllCustomers()
             .stream()
             .map(customerMapper::getDtoFrom)
             .collect(Collectors.toList());
   }

   @GetMapping("/{id}")
   public CustomerDTO getCustomerById(@PathVariable  Long id){
      return customerMapper.getDtoFrom(customerService.findById(id));
   }

   @PostMapping({"", "/"})
   @ResponseStatus(HttpStatus.CREATED)
   public CustomerDTO createCustomer(@RequestBody @Valid CustomerDTO customerDTO) {
      Customer created = customerService.create(customerMapper.getEntityFrom(customerDTO));
      return customerMapper.getDtoFrom(created);
   }

   @PutMapping("/{id}")
   @ResponseStatus(HttpStatus.NO_CONTENT)
   public CustomerDTO updateCustomer(@PathVariable Long id, @RequestBody @Valid CustomerDTO customerDTO) {
      Customer updated = customerService.update(id, customerMapper.getEntityFrom(customerDTO));
      return customerMapper.getDtoFrom(updated);
   }
}