package com.ignacio_albornoz.cv_virtual.models;

import com.ignacio_albornoz.cv_virtual.repositories.TechnologiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Set;

@Entity
@Table(name = "technologies")
public class TechnologiesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @ManyToMany(mappedBy = "technologies")
    private Set<CourseModel> courses;

    @Column(unique = true, nullable = false)
    private String title;
    private String description;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<CourseModel> getCourses() {
        return courses;
    }

    public void setCourses(Set<CourseModel> courses) {
        this.courses = courses;
    }

    @Service
    public static class TechnologiesService {
        @Autowired
        TechnologiesRepository technologiesRepository;

        public ArrayList<TechnologiesModel> getTechnologies(){
            return (ArrayList<TechnologiesModel>) technologiesRepository.findAll();
        }

        public TechnologiesModel saveTechnologies(TechnologiesModel technology){
            return (TechnologiesModel) technologiesRepository.save(technology);
        }

        public Optional<TechnologiesModel> getTechnologiesById(Long id){
            return technologiesRepository.findById(id);
        }

        public ArrayList<TechnologiesModel> getTechnologiesByTitle(String title){
            return technologiesRepository.findByTitle(title);
        }

        public boolean deleteTechnology(Long id){
            try {
                technologiesRepository.deleteById(id);
                return true;
            }catch (Exception err){
                return false;
            }
        }
    }

}
