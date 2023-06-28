package com.ignacio_albornoz.cv_virtual.controller;

import com.ignacio_albornoz.cv_virtual.dto.UserDTO;
import com.ignacio_albornoz.cv_virtual.models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserController {
    @Autowired
    UserModel.UserService userService;


    @GetMapping()
    public List<UserDTO> getUsers() {
        List<UserModel> users = userService.getUser();
        List<UserDTO> userDTOS = users.stream()
                .map(UserDTO::new)
                .collect(Collectors.toList());

        return userDTOS;
    }

    @PostMapping()
    public UserModel saveCourse(@RequestBody UserModel user){
        return this.userService.saveUser(user);
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
}
