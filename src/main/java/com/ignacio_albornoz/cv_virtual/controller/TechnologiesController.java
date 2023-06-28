package com.ignacio_albornoz.cv_virtual.controller;

import com.ignacio_albornoz.cv_virtual.models.TechnologiesModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/technologies")
public class TechnologiesController {

    @Autowired
    TechnologiesModel.TechnologiesService technologiesService;

    @GetMapping()
    public ArrayList<TechnologiesModel> getTechnologies(){
        return technologiesService.getTechnologies();
    }

    @PostMapping()
    public TechnologiesModel saveTechnologies(@RequestBody TechnologiesModel technology){
        return this.technologiesService.saveTechnologies(technology);
    }

    @GetMapping( path = "/{id}")
    public Optional<TechnologiesModel> getTechnologiesById(@PathVariable("id") Long id){
        return this.technologiesService.getTechnologiesById(id);
    }

    @GetMapping("/query")
    public ArrayList<TechnologiesModel> getTechnologiesByTitle(@RequestParam("title") String title){
        return this.technologiesService.getTechnologiesByTitle(title);
    }

}
