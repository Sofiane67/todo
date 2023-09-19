package com.socode.todo.repositories;

import com.socode.todo.entities.Status;
import com.socode.todo.entities.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Integer> {
}
