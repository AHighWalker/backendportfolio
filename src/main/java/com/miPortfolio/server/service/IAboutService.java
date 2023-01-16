
package com.miPortfolio.server.service;

import com.miPortfolio.server.model.About;
import java.util.List;
import java.util.Optional;


public interface IAboutService {
    
    public List<About> bringAbout();
    public void createAbout(About about);
    public void deleteAbout(Long idAbout);
    public About findAbout(Long idAbout);
    public Optional<About> getOne(Long idAbout);
}
