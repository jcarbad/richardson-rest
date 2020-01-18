package com.jcarbad.richardsonrest.api.v1.mapper;

import com.jcarbad.richardsonrest.api.v1.model.CategoryDTO;
import com.jcarbad.richardsonrest.domain.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryMapper {

   CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

   CategoryDTO getDtoFrom(Category category);
}
