package com.ecom.userservice.repository;

import com.ecom.userservice.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByrole(String role);
}
