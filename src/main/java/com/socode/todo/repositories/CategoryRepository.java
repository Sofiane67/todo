package com.socode.todo.repositories;

import com.socode.todo.entities.Category;
import com.socode.todo.entities.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
