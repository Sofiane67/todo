package com.socode.todo.repositories;

import com.socode.todo.entities.Subtask;
import com.socode.todo.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubtaskRepository extends JpaRepository<Subtask, Integer> {
    List<Subtask> findSubtasksByTaskId(int taskId);
}
