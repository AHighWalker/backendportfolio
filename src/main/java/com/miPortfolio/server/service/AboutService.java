
package com.miPortfolio.server.service;

import com.miPortfolio.server.model.About;
import com.miPortfolio.server.repository.AboutRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AboutService implements IAboutService{
    
    @Autowired
    public AboutRepository aboutRepo;
    
    
    @Override
    public List<About> bringAbout(){
        return aboutRepo.findAll();
    }
    
    @Override
    public void createAbout(About about){
        aboutRepo.save(about);
    }
    
    @Override
    public void deleteAbout(Long idAbout){
        aboutRepo.deleteById(idAbout);
    }
    
    @Override
    public About findAbout(Long idAbout){
        return aboutRepo.findById(idAbout).orElse(null);
    }
    
    @Override
    public Optional<About> getOne(Long idAbout){
        return aboutRepo.findById(idAbout);
    }
}
