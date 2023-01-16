
package com.miPortfolio.server.service;

import com.miPortfolio.server.model.SoftSkills;
import com.miPortfolio.server.repository.SoftSkillsRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SoftSkillsService implements ISoftSkillsService{
    
    @Autowired
    public SoftSkillsRepository SSRepo;
    
    @Override
    public List<SoftSkills> bringSoftSkills(){
        return SSRepo.findAll();
    }
    
    @Override
    public void createSoftSkill(SoftSkills softSkill){
        SSRepo.save(softSkill);
    }
    
    @Override
    public void deleteSoftSkill(Long idSS){
        SSRepo.deleteById(idSS);
    }
    
    @Override 
    public SoftSkills findSoftSkill(Long idSS){
        return SSRepo.findById(idSS).orElse(null);
    }
    
    @Override
    public Optional<SoftSkills> getOne(Long idSS){
        return SSRepo.findById(idSS);
    }
}
