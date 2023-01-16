
package com.miPortfolio.server.controller;

import com.miPortfolio.server.model.Education;
import com.miPortfolio.server.service.IEducationService;
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
public class EducationController {
    
    @Autowired
    private IEducationService eduServ;
    
    @PostMapping("/education/new")
    @PreAuthorize("hasRole('ADMIN')")
    public void addEducation(@RequestBody Education edu){
        eduServ.createEducation(edu);
    }
    
    @GetMapping("/education/bring")
    @ResponseBody
    public List<Education> bringEducation(){
        return eduServ.bringEducation();
    }
    
    @DeleteMapping("/education/delete/{idEdu}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteEducation(@PathVariable Long idEdu){
        eduServ.deleteEducation(idEdu);
    }
    
    @GetMapping("/education/detail/{idEdu}")
    public ResponseEntity<Education> getById(@PathVariable("idEdu") Long idEdu){
        Education education = eduServ.getOne(idEdu).get();
        return new ResponseEntity(education, HttpStatus.OK);
    }
    
    @PutMapping("/education/edit/{idEdu}")
    @PreAuthorize("hasRole('ADMIN')")
    public Education editEducation(@PathVariable Long idEdu, @RequestBody Education edu){
        Education education = eduServ.findEducation(idEdu);
        
        education.setTitleEdu(edu.getTitleEdu());
        education.setDescriptionEdu(edu.getDescriptionEdu());
        education.setDateEdu(edu.getDateEdu());
        education.setPictureEdu(edu.getPictureEdu());
        
        eduServ.createEducation(education);
        return education;
    }
}
