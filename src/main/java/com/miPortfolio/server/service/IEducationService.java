
package com.miPortfolio.server.service;

import com.miPortfolio.server.model.Education;
import java.util.List;
import java.util.Optional;


public interface IEducationService {
    
    public List<Education> bringEducation();
    public void createEducation(Education edu);
    public void deleteEducation(Long idEdu);
    public Education findEducation(Long idEdu);
    public Optional<Education> getOne(Long idEdu);
}
