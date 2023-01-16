
package com.miPortfolio.server.service;

import com.miPortfolio.server.model.HardSkills;
import com.miPortfolio.server.repository.HardSkillsRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HardSkillsService implements IHardSkillsService{
    
    @Autowired
    public HardSkillsRepository HSRepo;
    
    @Override
    public List<HardSkills> bringHardSkills(){
        return HSRepo.findAll();
    }
    
    @Override
    public void createHardSkills(HardSkills hardSkill){
    HSRepo.save(hardSkill);
    }
    
    @Override
    public void deleteHardSkills(Long idHS){
        HSRepo.deleteById(idHS);
    }
    
    @Override
    public HardSkills findHardSkills(Long idHS){
        return HSRepo.findById(idHS).orElse(null);
    }
    
    @Override
    public Optional<HardSkills> getOne(Long idHS){
        return HSRepo.findById(idHS);
    }

}
