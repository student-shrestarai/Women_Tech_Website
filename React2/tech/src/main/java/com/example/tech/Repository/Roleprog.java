package com.example.tech.Repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.example.tech.Entity.Role_Progression;

public interface Roleprog extends CrudRepository<Role_Progression , UUID> {

    List<Role_Progression> findByFromRole_Id(UUID fromRoleId);

    // Optional: Find all progressions leading to a specific role
    List<Role_Progression> findByToRole_Id(UUID fromRoleId);
    
}
