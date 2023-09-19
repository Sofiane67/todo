package com.socode.todo.services;

import com.socode.todo.entities.Category;
import com.socode.todo.entities.Priority;
import com.socode.todo.entities.Status;
import com.socode.todo.entities.Tag;
import com.socode.todo.repositories.CategoryRepository;
import com.socode.todo.repositories.PriorityRepository;
import com.socode.todo.repositories.StatusRepository;
import com.socode.todo.repositories.TagRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InitService {
    private StatusRepository statusRepository;
    private CategoryRepository categoryRepository;
    private PriorityRepository priorityRepository;
    private TagRepository tagRepository;

    public InitService(StatusRepository statusRepository, CategoryRepository categoryRepository, PriorityRepository priorityRepository, TagRepository tagRepository){
        this.statusRepository = statusRepository;
        this.categoryRepository = categoryRepository;
        this.priorityRepository = priorityRepository;
        this.tagRepository = tagRepository;
    }

    public void setStatus(){
        List<Status> statusList = new ArrayList<>();

        String[] stList = {"Planifiée", "En cours", "En attente", "Terminée", "Annulée"};
        for (String item : stList) {
            Status status = new Status();
            status.setName(item);
            statusList.add(status);
        }

        this.statusRepository.saveAll(statusList);
    }

    public void setCategories(){
        List<Category> categories = new ArrayList<>();

        String[] catList = {"Loisirs", "Maison", "Famille", "Enfant", "Santé"};
        for (String item : catList) {
            Category catégory = new Category();
            catégory.setName(item);
            categories.add(catégory);
        }
        this.categoryRepository.saveAll(categories);
    }

    public void setPriority(){
        List<Priority> priorities = new ArrayList<>();
        String[] prioList = {"Basse", "Moyenne", "Haute", "Critique"};
        for (String item : prioList) {
            Priority priority = new Priority();
            priority.setName(item);
            priorities.add(priority);
        }
        this.priorityRepository.saveAll(priorities);
    }

    public void setTags(){
        List<Tag> tags = new ArrayList<>();

        String[] tagList = {"Planifier", "Organiser", "Préparer", "Appeler", "Rencontrer", "Rechercher", "Réparer", "Lecture", "Cinéma", "Sport", "Voyage", "Cuisine", "Jardinage", "Nettoyage", "Ménage", "Bricolage", "Anniversaire", "Vacances", "Sortie", "Ecole", "Jeux", "Apprentissage", "Devoirs", "Rendez-vous", "Médicaments", "Course"};

        for (String item: tagList) {
            Tag tag = new Tag();
            tag.setName(item);
            tags.add(tag);
        }

        this.tagRepository.saveAll(tags);
    }
}
