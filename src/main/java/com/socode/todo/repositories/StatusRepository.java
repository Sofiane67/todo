package com.socode.todo.repositories;

import com.socode.todo.entities.Board;
import com.socode.todo.entities.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, Integer> {
}
