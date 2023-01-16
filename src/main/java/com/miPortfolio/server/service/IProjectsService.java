
package com.miPortfolio.server.service;

import com.miPortfolio.server.model.Projects;
import java.util.List;
import java.util.Optional;


public interface IProjectsService {
    
    public List<Projects> bringProjects();
    public void createProject(Projects project);
    public void deleteProject(Long idProject);
    public Projects findProject(Long idProject);
    public Optional<Projects>getOne(Long idProject);
}
