
package com.miPortfolio.server.security.repository;

import com.miPortfolio.server.security.entity.Role;
import com.miPortfolio.server.security.enums.RoleName;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByRoleName (RoleName roleName);
    
}
