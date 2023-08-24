package com.ignacio_albornoz.cv_virtual.controller;

import com.ignacio_albornoz.cv_virtual.dto.SkillsDTO;
import com.ignacio_albornoz.cv_virtual.models.SkillsModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/skills")
public class SkillsController {

    @Autowired
    SkillsModel.SkillsService skillsService;

    @GetMapping()
    public List<SkillsDTO> getSkills() {
        List<SkillsModel> skills = skillsService.getSkill();
        List<SkillsDTO> skillsDTOS = skills.stream()
                .map(SkillsDTO::new)
                .collect(Collectors.toList());

        return skillsDTOS;
    }

    @PostMapping()
    public SkillsModel saveSkill(@RequestBody SkillsModel skill) { return this.skillsService.saveSkill(skill); };

}
