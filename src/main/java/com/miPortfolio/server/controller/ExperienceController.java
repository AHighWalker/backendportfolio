package com.miPortfolio.server.controller;

import com.miPortfolio.server.model.Experience;
import com.miPortfolio.server.service.IExperienceService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ExperienceController {

    @Autowired
    private IExperienceService expServ;

    @PostMapping("/experience/new")
    @PreAuthorize("hasRole('ADMIN')")
    public void addExperience(@RequestBody Experience exp) {
        expServ.createExperience(exp);
    }

    @GetMapping("/experience/bring")
    @ResponseBody
    public List<Experience> bringExperience() {
        return expServ.bringExperience();
    }

    @DeleteMapping("/experience/delete/{idExp}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteExperience(@PathVariable Long idExp) {
        expServ.deleteExperience(idExp);
    }

    @PutMapping("/experience/edit/{idExp}")
    @PreAuthorize("hasRole('ADMIN')")
    public Experience editExperience(@PathVariable Long idExp, @RequestBody Experience exp){
        Experience experience = expServ.findExperience(idExp);
        
        experience.setTitleExp(exp.getTitleExp());
        experience.setDescriptionExp(exp.getDescriptionExp());
        experience.setSinceExp(exp.getSinceExp());
        experience.setUntilExp(exp.getUntilExp());
        experience.setPictureExp(exp.getPictureExp());
        experience.setLocationExp(exp.getLocationExp());
        
        expServ.createExperience(experience);
        return experience;
    }
    
    @GetMapping("/experience/detail/{idExp}")
    public ResponseEntity<Experience> getById(@PathVariable("idExp") Long idExp){
        Experience experience = expServ.getOne(idExp).get();
        return new ResponseEntity(experience, HttpStatus.OK);
    }
    
}
