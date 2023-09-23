package com.socode.todo.services;

import com.socode.todo.entities.Status;
import com.socode.todo.repositories.StatusRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusService {
    private StatusRepository statusRepository;

    public StatusService(StatusRepository statusRepository){
        this.statusRepository = statusRepository;
    }

    public List<Status> getStatus(){
        return this.statusRepository.findAll();
    }

    public Status getStatusById(int id){
        return this.statusRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Le status n'existe pas"));
    }

    public Status createStatus(Status status){
        return this.statusRepository.save(status);
    }

    public void editStatus(int id, Status statusEdited){
        Status status = this.getStatusById(id);
        if(status != null){
            status.setName(statusEdited.getName());
            this.statusRepository.save(status);
        }
    }

    public void removeStatus(int id){
        this.statusRepository.deleteById(id);
    }
}
