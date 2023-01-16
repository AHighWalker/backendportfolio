
package com.miPortfolio.server.controller;

import com.miPortfolio.server.model.SoftSkills;
import com.miPortfolio.server.service.ISoftSkillsService;
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
public class SoftSkillsController {
    
    @Autowired
    private ISoftSkillsService SSServ;
    
    @PostMapping("/softskills/new")
    @PreAuthorize("hasRole('ADMIN')")
    public void addSoftSkill(@RequestBody SoftSkills softSkill){
        SSServ.createSoftSkill(softSkill);
    }
    
    @GetMapping("/softskills/bring")
    @ResponseBody
    public List<SoftSkills> bringSoftSkills(){
        return SSServ.bringSoftSkills();
    }
    
    @DeleteMapping("/softskills/delete/{idSS}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteSoftSkill(@PathVariable Long idSS){
        SSServ.deleteSoftSkill(idSS);
    }
    
    @GetMapping("/softskills/detail/{idSS}")
    public ResponseEntity<SoftSkills> getById(@PathVariable("idSS") Long idSS){
        SoftSkills softskills = SSServ.getOne(idSS).get();
        return new ResponseEntity(softskills, HttpStatus.OK);
    }
    
    @PutMapping("/softskills/edit/{idSS}")
    @PreAuthorize("hasRole('ADMIN')")
    public SoftSkills editSoftSkills(@PathVariable Long idSS, @RequestBody SoftSkills softskills){
        SoftSkills sS = SSServ.findSoftSkill(idSS);
        
        sS.setTitleSS(softskills.getTitleSS());
        sS.setPercentageSS(softskills.getPercentageSS());
        sS.setPictureSS(softskills.getPictureSS());
        
        SSServ.createSoftSkill(sS);
        return sS;
    }
}
