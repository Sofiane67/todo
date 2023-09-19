package com.socode.todo.repositories;

import com.socode.todo.entities.Priority;
import com.socode.todo.entities.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriorityRepository extends JpaRepository<Priority, Integer> {
}
