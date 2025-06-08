package com.example.tech.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tech.Service.Rolservice;
import com.example.tech.Entity.Role;



@RestController
@RequestMapping("/role")
@CrossOrigin(origins = "http://localhost:3000")
public class RoleController {

    @Autowired
    private Rolservice service ;



@PostMapping
public ResponseEntity<?> saverole(@RequestBody List<Role> roles)

{

    List<Role> savedRoles = new ArrayList<>();
    for(Role role:roles) {
       
        Role savedrole = this.service.post_role(role);
        savedRoles.add(savedrole);
    }
    return ResponseEntity.ok(savedRoles);
}

@GetMapping
 public ResponseEntity<?> getrole() {
     return ResponseEntity.ok(this.service.get_role());
 }

// GET: Get User by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable UUID id) {
    Role role  = this.service.getById(id);
        if (role== null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("User with ID " + id + " does not exist");
        }
        return ResponseEntity.ok(role);
    }

    // DELETE: Delete User
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable UUID id) {
        Role role = this.service.getById(id); // here we will get role object if present 
        if (role == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("User with ID " + id + " does not exist");
        }
        this.service.delete_role(id);
        return ResponseEntity.ok("Role" + id + " deleted successfully");
    }

     

    // PUT: Update User
    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable UUID id, @RequestBody Role updated_role)
     {
        Role role = this.service.getById(id);
        if (role== null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Role with ID " + id + " does not exist");
        }
        Role updated;
        updated = this.service.update_role(id, updated_role);
        return ResponseEntity.ok(updated);
    }





    
}
