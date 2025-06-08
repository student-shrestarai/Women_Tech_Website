package com.example.tech.Controller;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.tech.Entity.Role_Progression;
import com.example.tech.Repository.Roleprog;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/role-progressions")
@CrossOrigin(origins = "http://localhost:3000")
public class RoleProgressionController {

    @Autowired
    private Roleprog roleProgressionRepository;

    // 1️⃣ Get all role progressions
    @GetMapping
    public Iterable<Role_Progression> getAllRoleProgressions() {
        return roleProgressionRepository.findAll();
    }

    // 2️⃣ Get role progressions by fromRoleId
    @GetMapping("/from/{fromRoleId}")
    public List<Role_Progression> getProgressionsFromRole(@PathVariable UUID fromRoleId) {
        return roleProgressionRepository.findByFromRole_Id(fromRoleId);
    }

    // 3️⃣ Get role progressions by toRoleId
    @GetMapping("/to/{toRoleId}")
    public List<Role_Progression> getProgressionsToRole(@PathVariable UUID toRoleId) {
        return roleProgressionRepository.findByToRole_Id(toRoleId);
    }

    // 4️⃣ Create a new role progression
    @PostMapping
    public ResponseEntity<?> createRoleProgression(@RequestBody   List<Role_Progression> roleProgression) {
        // You might want to add validation here
        List<Role_Progression> role_map = new ArrayList<>();
        for(Role_Progression rp : roleProgression){
           Role_Progression  role =   roleProgressionRepository.save(rp);

           role_map.add(role);
        }
        return ResponseEntity.ok(role_map);
       
    }

    // 5️⃣ Delete a role progression by id
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRoleProgression(@PathVariable UUID id) {
        Optional<Role_Progression> progression = roleProgressionRepository.findById(id);
        if (progression.isPresent()) {
            roleProgressionRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
