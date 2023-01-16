
package com.miPortfolio.server.service;

import com.miPortfolio.server.model.Profile;
import com.miPortfolio.server.repository.ProfileRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService implements IProfileService{
    
    @Autowired
    public ProfileRepository profileRepo;
    
    @Override
    public List<Profile> bringProfile(){
       return profileRepo.findAll();
    }
    
    @Override
    public void createProfile(Profile profile){
        profileRepo.save(profile);
    }
    
    @Override
    public void deleteProfile(Long idProfile){
        profileRepo.deleteById(idProfile);
    }
    
    @Override 
    public Profile findProfile(Long idProfile){
        return profileRepo.findById(idProfile).orElse(null);
    }
    
    @Override
    public Optional<Profile> getOne(Long idProfile){
        return profileRepo.findById(idProfile);
    }
}
