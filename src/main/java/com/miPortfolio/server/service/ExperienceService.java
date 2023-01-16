
package com.miPortfolio.server.service;

import com.miPortfolio.server.model.Experience;
import com.miPortfolio.server.repository.ExperienceRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienceService implements IExperienceService{
    
    @Autowired
    public ExperienceRepository expRepo;
    
    //Aniadir editar una vez hecho el htlm
    
    @Override
    public List<Experience> bringExperience(){
        return expRepo.findAll();
    }
    
    @Override 
    public void createExperience(Experience exp){
        expRepo.save(exp);
    }
    
    @Override 
    public void deleteExperience(Long idExp){
        expRepo.deleteById(idExp);
    }
    
    @Override
    public Experience findExperience(Long idExp){
        return expRepo.findById(idExp).orElse(null);
    }
    
    
    @Override
    public Optional<Experience> getOne(Long idExp){
        return expRepo.findById(idExp);
    }
}
