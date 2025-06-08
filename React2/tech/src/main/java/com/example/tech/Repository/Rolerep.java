package com.example.tech.Repository;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.example.tech.Entity.Role;



public interface Rolerep extends CrudRepository <Role, UUID> {
    
}
