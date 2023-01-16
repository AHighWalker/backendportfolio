
package com.miPortfolio.server.controller;

import com.miPortfolio.server.model.HardSkills;
import com.miPortfolio.server.service.IHardSkillsService;
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
public class HardSkillsController {
    
    @Autowired 
     private IHardSkillsService HSServ;
    
    @PostMapping("/hardskills/new")
    @PreAuthorize("hasRole('ADMIN')")
    public void addHardSkills(@RequestBody HardSkills hardSkill){
        HSServ.createHardSkills(hardSkill);
    }
    
    @GetMapping("/hardskills/bring")
    @ResponseBody
    public List<HardSkills> bringHardSkills(){
        return HSServ.bringHardSkills();
    }
    
    @DeleteMapping("/hardskills/delete/{idHS}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteHardSkills(@PathVariable Long idHS){
        HSServ.deleteHardSkills(idHS);
    }
    
    @GetMapping("/hardskills/detail/{idHS}")
    public ResponseEntity<HardSkills> getById(@PathVariable("idHS") Long idHS){
        HardSkills hardskills = HSServ.getOne(idHS).get();
        return new ResponseEntity(hardskills, HttpStatus.OK);
    }
    
    @PutMapping("/hardskills/edit/{idHS}")
    @PreAuthorize("hasRole('ADMIN')")
    public HardSkills editHardSkills(@PathVariable Long idHS, @RequestBody HardSkills hardskills){
        HardSkills hS = HSServ.findHardSkills(idHS);
        
        hS.setTitleHS(hardskills.getTitleHS());
        hS.setPercentageHS(hardskills.getPercentageHS());
        hS.setPictureHS(hardskills.getPictureHS());
        
        HSServ.createHardSkills(hS);
        return hS;
    }
}
