
package com.miPortfolio.server.controller;

import com.miPortfolio.server.model.Profile;
import com.miPortfolio.server.service.IProfileService;
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
public class ProfileController {
    
    @Autowired
    private IProfileService profileServ;
    
    @PostMapping("/profile/new")
    @PreAuthorize("hasRole('ADMIN')")
    public void addProfile(@RequestBody Profile profile){
        profileServ.createProfile(profile);
    }
    
    @GetMapping("/profile/bring")
    @ResponseBody
    public List<Profile> bringProfile(){
        return profileServ.bringProfile();
    }
    
    @DeleteMapping("/profile/delete/{idProfile}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteProfile(@PathVariable Long idProfile){
        profileServ.deleteProfile(idProfile);
    }
    
    @GetMapping("/profile/find/{idProfile}")
    @ResponseBody
    public Profile findProfile(@PathVariable Long idProfile){
        return profileServ.findProfile(idProfile);
    }
    
    @GetMapping("/profile/detail/{idProfile}")
    public ResponseEntity<Profile> getById(@PathVariable("idProfile") Long idProfile){
        Profile profile = profileServ.getOne(idProfile).get();
        return new ResponseEntity(profile, HttpStatus.OK);
    }
    
    @PutMapping("/profile/edit/{idProfile}")
    @PreAuthorize("hasRole('ADMIN')")
    public Profile editAbout(@PathVariable Long idProfile, @RequestBody Profile profile){
        Profile profile2 = profileServ.findProfile(idProfile);
        
        profile2.setNameProfile(profile.getNameProfile());
        profile2.setDescriptionProfile(profile.getDescriptionProfile());
        profile2.setLocationProfile(profile.getLocationProfile());
        profile2.setPictureProfile(profile.getPictureProfile());
        profile2.setBannerProfile(profile.getBannerProfile());
        
        
        profileServ.createProfile(profile2);
        return profile2;
    }
}
