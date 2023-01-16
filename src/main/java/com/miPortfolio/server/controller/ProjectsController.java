
package com.miPortfolio.server.controller;

import com.miPortfolio.server.model.Projects;
import com.miPortfolio.server.service.IProjectsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProjectsController {
    
    @Autowired
    private IProjectsService proServ;
    
    @PostMapping("/projects/new")
    @PreAuthorize("hasRole('ADMIN')")
    public void addProject(@RequestBody Projects project){
        proServ.createProject(project);
    }
    
    @GetMapping("/projects/bring")
    @ResponseBody
    public List<Projects> bringProjects(){
        return proServ.bringProjects();
    }
    
    @DeleteMapping("/projects/delete/{idProject}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteProject(@PathVariable Long idProject){
        proServ.deleteProject(idProject);
    }
    
    @GetMapping("/projects/detail/{idProject}")
    public ResponseEntity<Projects> getById(@PathVariable("idProject") Long idProject){
        Projects projects = proServ.getOne(idProject).get();
        return new ResponseEntity(projects, HttpStatus.OK);
    }
    
    @PutMapping("/projects/edit/{idProject}")
    @PreAuthorize("hasRole('ADMIN')")
    public Projects editProjects(@PathVariable Long idProject, @RequestBody Projects pro){
        Projects projects = proServ.findProject(idProject);
        
        projects.setTitleProject(pro.getTitleProject());
        projects.setDescriptionProject(pro.getDescriptionProject());
        projects.setPictureProject(pro.getPictureProject());
        projects.setLinkProject(pro.getLinkProject());
        
        proServ.createProject(projects);
        return projects;
    }
}
