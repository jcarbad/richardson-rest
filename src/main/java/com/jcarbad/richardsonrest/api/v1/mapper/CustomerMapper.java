package com.jcarbad.richardsonrest.api.v1.mapper;

import com.jcarbad.richardsonrest.api.v1.model.CustomerDTO;
import com.jcarbad.richardsonrest.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {

   CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

   @Mapping(source = "id", target = "customerUrl", qualifiedByName = "idToHyperLink")
   CustomerDTO getDtoFrom(Customer customer);

   @Named("idToHyperLink")
   static String idToHyperLink(Long id) {
      return "/api/v1/customers/" + id;
   }
}
