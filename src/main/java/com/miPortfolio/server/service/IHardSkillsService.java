
package com.miPortfolio.server.service;

import com.miPortfolio.server.model.HardSkills;
import java.util.List;
import java.util.Optional;

public interface IHardSkillsService {
    public List<HardSkills> bringHardSkills();
    public void createHardSkills(HardSkills hardSkill);
    public void deleteHardSkills(Long idHS);
    public HardSkills findHardSkills(Long idHS);
    public Optional<HardSkills> getOne(Long idHS);
}
