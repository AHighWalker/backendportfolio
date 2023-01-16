
package com.miPortfolio.server.controller;

import com.miPortfolio.server.model.About;
import com.miPortfolio.server.service.IAboutService;
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
public class AboutController {
    
    @Autowired 
    private IAboutService aboutServ;
    
    @PostMapping("/about/new")
    @PreAuthorize("hasRole('ADMIN')")
    public void addAbout(@RequestBody About about){
        aboutServ.createAbout(about);
    }
    
    @GetMapping("/about/bring")
    @ResponseBody
    public List<About> bringAbout(){
        return aboutServ.bringAbout();
    }
    
    @DeleteMapping("/about/delete/{idEdu}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteAbout(@PathVariable Long idAbout){
        aboutServ.deleteAbout(idAbout);
    }
    
    @GetMapping("/about/find/{idAbout}")
    @ResponseBody
    public About findAbout(@PathVariable Long idAbout){
        return aboutServ.findAbout(idAbout);
    }
    
    @GetMapping("/about/detail/{idAbout}")
    public ResponseEntity<About> getById(@PathVariable("idAbout") Long idAbout){
        About about = aboutServ.getOne(idAbout).get();
        return new ResponseEntity(about, HttpStatus.OK);
    }
    
    @PutMapping("/about/edit/{idAbout}")
    @PreAuthorize("hasRole('ADMIN')")
    public About editAbout(@PathVariable Long idAbout, @RequestBody About about){
        About about2 = aboutServ.findAbout(idAbout);
        
        about2.setDescriptionAbout(about.getDescriptionAbout());
        
        
        aboutServ.createAbout(about2);
        return about2;
    }
}

