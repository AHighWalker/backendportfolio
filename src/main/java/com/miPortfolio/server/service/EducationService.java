
package com.miPortfolio.server.service;

import com.miPortfolio.server.model.Education;
import com.miPortfolio.server.repository.EducationRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducationService implements IEducationService{
    
    @Autowired
    public EducationRepository eduRepo;
    
    //Añadir metodo editar una vez hecho el html
    
    @Override
    public List<Education> bringEducation(){
        return eduRepo.findAll();
    }
    
    @Override
    public void createEducation(Education edu){
        eduRepo.save(edu);
    }
    
    @Override
    public void deleteEducation(Long idEdu){
        eduRepo.deleteById(idEdu);
    }
    
    @Override
    public Education findEducation(Long idEdu){
        return eduRepo.findById(idEdu).orElse(null);
    }
    
    @Override
    public Optional<Education> getOne(Long idEdu){
        return eduRepo.findById(idEdu);
    }
}
