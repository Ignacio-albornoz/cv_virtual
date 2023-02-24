package com.ignacio_albornoz.cv_virtual.services;

import com.ignacio_albornoz.cv_virtual.models.CourseModel;
import com.ignacio_albornoz.cv_virtual.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;


@Service
public class CourseService {
    @Autowired
    CourseRepository courseRepository;

    public ArrayList<CourseModel> getCourses(){
        return (ArrayList<CourseModel>) courseRepository.findAll();
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
