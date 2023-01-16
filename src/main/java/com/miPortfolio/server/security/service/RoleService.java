
package com.miPortfolio.server.security.service;

import com.miPortfolio.server.security.entity.Role;
import com.miPortfolio.server.security.enums.RoleName;
import com.miPortfolio.server.security.repository.IRoleRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RoleService {
    
    @Autowired
    IRoleRepository iRolRepository;
    
    public Optional<Role> getByRoleName(RoleName rolName){
        return iRolRepository.findByRoleName(rolName);
    } 
    
    public void save(Role role){
        iRolRepository.save(role);
    }
}
