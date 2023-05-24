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
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    CourseModel.CourseService courseService;

    @GetMapping()
    public ArrayList<CourseModel> getCourses(){
        return courseService.getCourses();
    }

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
            CoursesDTO dto = new CoursesDTO();
            dto.setId(course.getId());
            dto.setTitle(course.getTitle());
            dto.setDescription(course.getDescription());
            dto.setDuration(course.getDuration());
            dto.setEstablishment(course.getEstablishment());
            dto.setFinishedMonth(course.getFinishedMonth());
            dto.setStartMonth(course.getStartMonth());


            // ...
            Set<CategoriesDTO> categories = new HashSet<>();
            for (CategoriesModel category : course.getCategories()) {
                CategoriesDTO categoryDTO = new CategoriesDTO();
                categoryDTO.setId(category.getId());
                categoryDTO.setTitle(category.getTitle());
                categoryDTO.setDescription(category.getDescription());
                categories.add(categoryDTO);
            }
            dto.setCategories(categories);
            return dto;
        });


        return new ResponseEntity<>(courseDTO, HttpStatus.OK).getBody();
    }

}
