package com.ignacio_albornoz.cv_virtual.controller;

import com.ignacio_albornoz.cv_virtual.models.CourseModel;
import com.ignacio_albornoz.cv_virtual.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    CourseService courseService;

    @GetMapping()
    public ArrayList<CourseModel> getCourses(){
        return courseService.getCourses();
    }

    @PostMapping()
    public CourseModel saveCourse(@RequestBody CourseModel course){
        return this.courseService.saveCourses(course);
    }

    @GetMapping( path = "/{id}")
    public Optional<CourseModel> getCourseById(@PathVariable("id") Long id){
        return this.courseService.getCourseById(id);
    }

    @GetMapping("/query")
    public ArrayList<CourseModel> getCourseByTitle(@RequestParam("title") String title){
        return this.courseService.getCourseByTitle(title);
    }

}
