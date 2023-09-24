package com.socode.todo.services;

import com.socode.todo.entities.Subtask;
import com.socode.todo.entities.Task;
import com.socode.todo.repositories.SubtaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubtaskService {
    private SubtaskRepository subtaskRepository;
    private TaskService taskService;

    public SubtaskService(SubtaskRepository subtaskRepository, TaskService taskService){
        this.subtaskRepository = subtaskRepository;
        this.taskService = taskService;
    }

    public List<Subtask> getSubtasks(int taskId){
        return this.subtaskRepository.findSubtasksByTaskId(taskId);
    }

    public Subtask getSubtaskById(int id){
        return this.subtaskRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("La sous-tâche n'existe pas"));
    }

    public void createSubTask(int taskId, Subtask subtask){
        Task task = this.taskService.getTaskById(taskId);
        if(task != null){
            subtask.setTask(task);
        }
        this.subtaskRepository.save(subtask);
    }

    public void editSubtask(int id, Subtask editedSubtask){
        Subtask subtask = this.getSubtaskById(id);
        if(subtask != null){
            subtask.setTitle(editedSubtask.getTitle());
            subtask.setDescription(editedSubtask.getDescription());
            subtask.setCompleted(editedSubtask.isCompleted());
            this.subtaskRepository.save(subtask);
        }
    }

    public void removeSubTask(int id){
        this.subtaskRepository.deleteById(id);
    }
}
