package com.example.tech.Service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tech.Entity.Role;
import com.example.tech.Repository.Rolerep;

@Service
public class Rolservice {

    @Autowired
    private Rolerep role_repo;
    private Role role;



    public Role post_role(Role newrole){
        return this.role_repo.save(newrole);
    }


    public Iterable<Role> get_role(){
        return this.role_repo.findAll();
    }

    


public Role getById(UUID id)
{// return the controller a role object
    return this.role_repo.findById(id).orElse(null);
}

public void delete_role(UUID id)
{
    this.role_repo.deleteById(id);
}



public Role update_role (UUID id , Role updated_role){
    role.setId(id);
    return this.role_repo.save( updated_role);
}


    
}