
package com.miPortfolio.server.service;

import com.miPortfolio.server.model.Profile;
import java.util.List;
import java.util.Optional;


public interface IProfileService {
    
    public List<Profile> bringProfile();
    public void createProfile(Profile profile);
    public void deleteProfile(Long idProfile);
    public Profile findProfile(Long idProfile);
    public Optional<Profile>getOne(Long idProfile);
}
