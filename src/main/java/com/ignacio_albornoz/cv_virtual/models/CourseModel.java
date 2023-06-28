package com.ignacio_albornoz.cv_virtual.models;

import com.ignacio_albornoz.cv_virtual.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Entity
@Table(name = "courses")
public class CourseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "courses_categories",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<CategoriesModel> categories = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "courses_technologies",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "technologies_id"))
    private Set<TechnologiesModel> technologies = new HashSet<>();

    @Column(unique = true, nullable = false)
    private String title;
    private String description;
    private Integer duration;
    @Column(name = "start_year")
    private Integer startYear;
    @Column(name = "start_month")
    private Integer startMonth;
    @Column(name = "finished_year")
    private Integer finishedYear;
    @Column(name = "finished_month")
    private Integer finishedMonth;
    private String establishment;

    /*Getters & Setters*/

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

    public String getEstablishment() {
        return establishment;
    }

    public void setEstablishment(String establishment) {
        this.establishment = establishment;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getStartYear() {
        return startYear;
    }

    public void setStartYear(Integer startYear) {
        this.startYear = startYear;
    }

    public Integer getStartMonth() {
        return startMonth;
    }

    public void setStartMonth(Integer startMonth) {
        this.startMonth = startMonth;
    }

    public Integer getFinishedYear() {
        return finishedYear;
    }

    public void setFinishedYear(Integer finishedYear) {
        this.finishedYear = finishedYear;
    }

    public Integer getFinishedMonth() {
        return finishedMonth;
    }

    public void setFinishedMonth(Integer finishedMonth) {
        this.finishedMonth = finishedMonth;
    }

    public Set<CategoriesModel> getCategories() {
        return categories;
    }

    public void setCategories(Set<CategoriesModel> categories) {
        this.categories = categories;
    }

    public Set<TechnologiesModel> getTechnologies() {
        return technologies;
    }

    public void setTechnologies(Set<TechnologiesModel> technologies) {
        this.technologies = technologies;
    }

    /*Service*/

    @Service
    public static class CourseService {
        @Autowired
        CourseRepository courseRepository;


        public ArrayList<CourseModel> getCourses(){
            return (ArrayList<CourseModel>) courseRepository.findAll();
        }

        public ArrayList<String> getCourseTitles() {
            return (ArrayList<String>) courseRepository.findCourseTitles();
        }

        public CourseModel saveCourses(CourseModel course){
            return (CourseModel) courseRepository.save(course);
        }

        public Optional<CourseModel> getCourseById(Long id){
            return courseRepository.findById(id);
        }

        public ArrayList<CourseModel> getCourseByTitle(String title){
            return courseRepository.findByTitle(title);
        }

        public boolean deleteCourse(Long id){
            try {
                courseRepository.deleteById(id);
                return true;
            }catch (Exception err){
                return false;
            }
        }
    }
}
