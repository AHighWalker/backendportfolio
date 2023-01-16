
package com.miPortfolio.server.repository;

import com.miPortfolio.server.model.SoftSkills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoftSkillsRepository extends JpaRepository<SoftSkills,Long>{
    
}
