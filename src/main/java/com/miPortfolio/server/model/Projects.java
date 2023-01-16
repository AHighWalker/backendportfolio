package com.miPortfolio.server.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
@Entity
public class Projects {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    Long idProject;
    
    String titleProject;
    String descriptionProject;
    String pictureProject;
    String linkProject;

    public Projects() {
    }

    public Projects(Long idProject, String titleProject, String descriptionProject, String pictureProject, String linkProject) {
        this.idProject = idProject;
        this.titleProject = titleProject;
        this.descriptionProject = descriptionProject;
        this.pictureProject = pictureProject;
        this.linkProject = linkProject;
    }

 
    
}
