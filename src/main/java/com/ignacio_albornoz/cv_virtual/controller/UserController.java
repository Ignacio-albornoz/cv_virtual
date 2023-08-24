package com.ignacio_albornoz.cv_virtual.controller;

import com.ignacio_albornoz.cv_virtual.dto.UserDTO;
import com.ignacio_albornoz.cv_virtual.models.SkillsModel;
import com.ignacio_albornoz.cv_virtual.models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserModel.UserService userService;

    @Autowired
    private SkillsModel.SkillsService skillsService;

    @GetMapping()
    public List<UserDTO> getUsers() {
        List<UserModel> users = userService.getUser();
        List<UserDTO> userDTOS = users.stream()
                .map(UserDTO::new)
                .collect(Collectors.toList());
        return userDTOS;
    }

    @GetMapping( "userID/{id}")
    public ArrayList<String> getCoursesTitleByUserId(@PathVariable("id") Long id) {
        return userService.getCoursesTitleByUserId(id);
    }

    @GetMapping( "skills/{id}")
    public ArrayList<String> getSkillsByUserId(@PathVariable("id") Long id) {
        return userService.getSkillsByUserId(id);
    }

    @GetMapping("/query")
    public ArrayList<UserModel> getUserByEmail(@RequestParam("email") String email){
        return this.userService.getUserByEmail(email);
    }

    @GetMapping(path = "/{id}")
    public Optional<UserDTO> getCourseByIdDTO(@PathVariable("id") Long id) {
        Optional<UserModel> users = this.userService.getUserById(id);
        Optional<UserDTO> userDTO = users.map(user -> {
            UserDTO dto = new UserDTO(user);
            return dto;
        });


        return new ResponseEntity<>(userDTO, HttpStatus.OK).getBody();
    }

    /*
    @PostMapping("/skills/add/{id}")
    public String addSkill(@PathVariable("id") Long id, @RequestBody SkillsRequest skillRequest) {
        userService.addSkill(id, skillRequest.getSkills(), skillRequest.getArea());
        return "Skills added successfully";
    }*/

    @PostMapping("/{userId}/skills")
    public UserModel addSkillToUser(@RequestBody SkillsModel skill, @PathVariable Long skillId) {
        SkillsModel savedSkill = skillsService.saveSkill(skill);
        return userService.addSkillToUser(savedSkill.getId(), skillId);
    }


    @PostMapping()
    public UserModel saveCourse(@RequestBody UserModel user){
        return this.userService.saveUser(user);
    }
}
