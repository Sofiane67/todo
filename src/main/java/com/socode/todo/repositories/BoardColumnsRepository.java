package com.socode.todo.repositories;

import com.socode.todo.entities.Board;
import com.socode.todo.entities.BoardColumns;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardColumnsRepository extends JpaRepository<BoardColumns, Integer> {

    List<BoardColumns> findBoardColumnsByBoardIdOrderByOrderColumnAsc(int BoardId);
    int countBoardColumnsByBoardId(int boardId);
}
