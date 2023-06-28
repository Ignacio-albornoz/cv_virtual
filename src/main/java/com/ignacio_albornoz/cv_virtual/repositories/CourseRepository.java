package com.ignacio_albornoz.cv_virtual.repositories;

import com.ignacio_albornoz.cv_virtual.models.CourseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface CourseRepository extends CrudRepository<CourseModel, Long> {
    public abstract ArrayList<CourseModel> findByTitle(String title);

    @Query(value = "SELECT title FROM courses", nativeQuery = true)
    public abstract ArrayList<String> findCourseTitles();

}

