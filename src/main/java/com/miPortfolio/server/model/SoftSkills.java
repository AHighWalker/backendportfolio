package com.miPortfolio.server.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
@Entity
public class SoftSkills {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    Long idSS;
    
    String titleSS;
    int percentageSS;
    String pictureSS;

    public SoftSkills() {
    }

    public SoftSkills(Long idSS, String titleSS, int percentageSS, String pictureSS) {
        this.idSS = idSS;
        this.titleSS = titleSS;
        this.percentageSS = percentageSS;
        this.pictureSS = pictureSS;
    }

  
    
}
