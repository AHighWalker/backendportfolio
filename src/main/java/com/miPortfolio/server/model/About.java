package com.miPortfolio.server.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
@Entity
public class About {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    Long idAbout;
    
    String descriptionAbout;

    public About() {
    }

    public About(Long idAbout, String descriptionAbout) {
        this.idAbout = idAbout;
        this.descriptionAbout = descriptionAbout;
    }

 
    
    
}
