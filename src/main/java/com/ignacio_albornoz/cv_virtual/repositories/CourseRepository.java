package com.ignacio_albornoz.cv_virtual.repositories;

import com.ignacio_albornoz.cv_virtual.models.CourseModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface CourseRepository extends CrudRepository<CourseModel, Long> {

    public abstract ArrayList<CourseModel> findByTitle(String title);

    @Query(value = "SELECT title FROM courses", nativeQuery = true)
    public abstract ArrayList<String> findCourseTitles();

    @Query(value = "SELECT users.id, courses.* FROM courses INNER JOIN users WHERE users.id = :courseId", nativeQuery = true)
    public abstract ArrayList<CourseModel> findCoursesByUserId(@Param("courseId") Long courseId);

}

