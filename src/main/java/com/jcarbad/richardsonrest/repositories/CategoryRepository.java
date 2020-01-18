package com.jcarbad.richardsonrest.repositories;

import com.jcarbad.richardsonrest.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
