
package com.miPortfolio.server.service;

import com.miPortfolio.server.model.Projects;
import com.miPortfolio.server.repository.ProjectsRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectsService implements IProjectsService{
    
    @Autowired
    public ProjectsRepository proRepo;
    
    @Override
    public List<Projects> bringProjects(){
        return proRepo.findAll();
    }
    
    @Override
    public void createProject(Projects project){
        proRepo.save(project);
    }
    
    @Override
    public void deleteProject(Long idProject){
        proRepo.deleteById(idProject);
    }
    
    @Override
    public Projects findProject(Long idProject){
        return proRepo.findById(idProject).orElse(null);
    }
    
    @Override
    public Optional<Projects> getOne(Long idProject){
        return proRepo.findById(idProject);
    }
}
