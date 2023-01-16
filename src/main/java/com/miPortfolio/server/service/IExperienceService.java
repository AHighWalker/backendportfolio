
package com.miPortfolio.server.service;

import com.miPortfolio.server.model.Experience;
import java.util.List;
import java.util.Optional;


public interface IExperienceService {
    
    public List<Experience> bringExperience();
    public void createExperience(Experience exp);
    public void deleteExperience(Long idExp);
    public Experience findExperience(Long idExp);
    public Optional<Experience> getOne(Long idExp);
}
