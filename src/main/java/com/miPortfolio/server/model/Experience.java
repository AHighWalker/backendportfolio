package com.miPortfolio.server.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
@Entity
public class Experience {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    Long idExp;
    
    String titleExp;
    String descriptionExp;
    String sinceExp;
    String untilExp;
    String pictureExp;
    String locationExp;
    
    public Experience() {
    }

    public Experience(Long idExp, String titleExp, String descriptionExp, String sinceExp, String untilExp, String pictureExp, String locationExp) {
        this.idExp = idExp;
        this.titleExp = titleExp;
        this.descriptionExp = descriptionExp;
        this.sinceExp = sinceExp;
        this.untilExp = untilExp;
        this.pictureExp = pictureExp;
        this.locationExp = locationExp;
    }

 

}
