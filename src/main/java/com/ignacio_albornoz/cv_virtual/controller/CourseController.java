package com.ignacio_albornoz.cv_virtual.controller;

import com.ignacio_albornoz.cv_virtual.dto.CategoriesDTO;
import com.ignacio_albornoz.cv_virtual.models.CategoriesModel;
import com.ignacio_albornoz.cv_virtual.models.CourseModel;
import com.ignacio_albornoz.cv_virtual.dto.CoursesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    CourseModel.CourseService courseService;

    @GetMapping()
    public List<CoursesDTO> getCourses() {
        List<CourseModel> courses = courseService.getCourses();
        List<CoursesDTO> courseDTOs = courses.stream()
                .map(CoursesDTO::new)
                .collect(Collectors.toList());

        return courseDTOs;
    }

    /*public ArrayList<CourseModel> getCourses(){
        return courseService.getCourses();
    }*/

    @PostMapping()
    public CourseModel saveCourse(@RequestBody CourseModel course){
        return this.courseService.saveCourses(course);
    }
    /*
    @GetMapping( path = "/{id}")
    public Optional<CourseModel> getCourseById(@PathVariable("id") Long id){
        return this.courseService.getCourseById(id);
    }*/

    @GetMapping("/query")
    public ArrayList<CourseModel> getCourseByTitle(@RequestParam("title") String title){
        return this.courseService.getCourseByTitle(title);
    }

    @GetMapping(path = "/{id}")
    public Optional<CoursesDTO> getCourseByIdDTO(@PathVariable("id") Long id) {
        Optional<CourseModel> courses = this.courseService.getCourseById(id);
        Optional<CoursesDTO> courseDTO = courses.map(course -> {
            CoursesDTO dto = new CoursesDTO(course);
            return dto;
        });


        return new ResponseEntity<>(courseDTO, HttpStatus.OK).getBody();
    }

}
