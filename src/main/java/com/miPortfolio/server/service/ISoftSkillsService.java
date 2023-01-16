
package com.miPortfolio.server.service;

import com.miPortfolio.server.model.SoftSkills;
import java.util.List;
import java.util.Optional;


public interface ISoftSkillsService {
    
    public List<SoftSkills> bringSoftSkills();
    public void createSoftSkill(SoftSkills softSkill);
    public void deleteSoftSkill(Long idSS);
    public SoftSkills findSoftSkill(Long idSS);
    public Optional<SoftSkills> getOne(Long idSS);
}
