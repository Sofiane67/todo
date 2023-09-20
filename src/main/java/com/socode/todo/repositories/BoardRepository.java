package com.socode.todo.repositories;

import com.socode.todo.entities.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Integer> {
}
