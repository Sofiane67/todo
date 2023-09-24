package com.socode.todo.services;

import com.socode.todo.entities.Board;
import com.socode.todo.entities.Status;
import com.socode.todo.entities.Task;
import com.socode.todo.repositories.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private TaskRepository taskRepository;
    private BoardService boardService;
    private StatusService statusService;
    public TaskService(TaskRepository taskRepository, BoardService boardService, StatusService statusService){
        this.taskRepository = taskRepository;
        this.boardService = boardService;
        this.statusService = statusService;
    }

    public List<Task> getTasks(){
        return this.taskRepository.findAll();
    }

    public Task getTaskById(int id){
        return this.taskRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("La tâche n'existe pas"));
    }

    public void createTask(Task task){
        if(task.getBoard() != null && task.getStatus() != null){
            Board board = this.boardService.getBoardById(task.getBoard().getId());
            Status status = this.statusService.getStatusById(task.getStatus().getId());
            task.setBoard(board);
            task.setStatus(status);

            System.out.println(task.getBoard().getName() + "  " + task.getStatus().getName());
        }
        this.taskRepository.save(task);
    }

    public void editTask(int id, Task editedTask){
        Task task = this.getTaskById(id);

        if(task != null){
            task.setTitle(editedTask.getTitle());
            task.setDescription(editedTask.getDescription());
            this.taskRepository.save(task);
        }
    }

    public void removeTask(int id){
        this.taskRepository.deleteById(id);
    }

}
