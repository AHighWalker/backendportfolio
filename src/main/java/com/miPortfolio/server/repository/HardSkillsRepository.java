
package com.miPortfolio.server.repository;

import com.miPortfolio.server.model.HardSkills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HardSkillsRepository extends JpaRepository<HardSkills, Long>{
    
}
