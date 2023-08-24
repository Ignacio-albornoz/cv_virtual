package com.ignacio_albornoz.cv_virtual.repositories;

import com.ignacio_albornoz.cv_virtual.models.UserModel;
import com.ignacio_albornoz.cv_virtual.response.SkillsResponse;
import com.ignacio_albornoz.cv_virtual.response.UserCourse;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.SqlResultSetMapping;
import java.util.ArrayList;

@SqlResultSetMapping(
        name = "UserCourseMapping",
        classes = @ConstructorResult(
                targetClass = UserCourse.class,
                columns = {
                        @ColumnResult(name = "email", type = String.class),
                        @ColumnResult(name = "title", type = String.class)
                }
        )
)

@SqlResultSetMapping(
        name = "SkillsResponseMapping",
        classes = @ConstructorResult(
                targetClass = SkillsResponse.class,
                columns = {
                        @ColumnResult(name = "name", type = String.class),
                        @ColumnResult(name = "email", type = String.class),
                        @ColumnResult(name = "skills", type = String.class)
                }
        )
)
@Repository
public interface UserRepository extends CrudRepository<UserModel, Long> {
    public abstract ArrayList<UserModel> findByEmail(String email);



    @Query(value = "SELECT users.id, users.email, courses.title, courses.id FROM users INNER JOIN courses WHERE users.id = :userId", nativeQuery = true)
    public abstract ArrayList<String> findCoursesTitleByUserId(@Param("userId") Long userId);

    @Query(value = "SELECT users.first_name, users.email, users.skills FROM users WHERE users.id = :userId", nativeQuery = true)
    public abstract ArrayList<String> findSkillsByUserId(@Param("userId") Long userId);

    @Query(value = "UPDATE users SET skills = :skills WHERE id = :userId", nativeQuery = true)
    public abstract  String addSkills(@Param("skills") String skills, Long userId);



}
