package com.miPortfolio.server.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
@Entity
public class Education {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    Long idEdu;
    
    String titleEdu;
    String descriptionEdu;
    String dateEdu;
    String pictureEdu;

    public Education() {
    }

    public Education(Long idEdu, String titleEdu, String descriptionEdu, String dateEdu, String pictureEdu) {
        this.idEdu = idEdu;
        this.titleEdu = titleEdu;
        this.descriptionEdu = descriptionEdu;
        this.dateEdu = dateEdu;
        this.pictureEdu = pictureEdu;
    }


}
