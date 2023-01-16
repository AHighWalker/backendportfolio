package com.miPortfolio.server.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
@Entity
public class Profile {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    Long idProfile;
  
    String nameProfile;
    String descriptionProfile;
    String locationProfile;
    String pictureProfile;
    String bannerProfile;

    public Profile() {
    }

    public Profile(Long idProfile, String nameProfile, String descriptionProfile, String locationProfile, String pictureProfile, String bannerProfile) {
        this.idProfile = idProfile;
        this.nameProfile = nameProfile;
        this.descriptionProfile = descriptionProfile;
        this.locationProfile = locationProfile;
        this.pictureProfile = pictureProfile;
        this.bannerProfile = bannerProfile;
    }

  

   
    
}
