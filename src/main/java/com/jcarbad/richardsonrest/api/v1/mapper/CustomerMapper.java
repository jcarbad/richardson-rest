package com.jcarbad.richardsonrest.api.v1.mapper;

import com.jcarbad.richardsonrest.api.v1.model.CustomerDTO;
import com.jcarbad.richardsonrest.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {

   CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

   @Mapping(source = "id", target = "customerUrl", qualifiedByName = "idToHyperLink")
   CustomerDTO getDtoFrom(Customer customer);

   Customer getEntityFrom(CustomerDTO dto);

   @Named("idToHyperLink")
   static String idToHyperLink(Long id) {
      return "/api/v1/customers/" + id;
   }
}
