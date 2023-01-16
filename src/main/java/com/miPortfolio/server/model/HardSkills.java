package com.miPortfolio.server.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
@Entity
public class HardSkills {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    Long idHS;
    
    String titleHS;
    int percentageHS;
    String pictureHS;

    public HardSkills() {
    }

    public HardSkills(Long idHS, String titleHS, int percentageHS, String pictureHS) {
        this.idHS = idHS;
        this.titleHS = titleHS;
        this.percentageHS = percentageHS;
        this.pictureHS = pictureHS;
    }

   
    
}
