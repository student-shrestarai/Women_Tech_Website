package com.example.tech.Entity;

import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "role_progression")
public class Role_Progression{

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "uuid2")

    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @ManyToOne
    @JoinColumn(name="from_role_id")
    private Role fromRole;



    @ManyToOne
    @JoinColumn(name="to_role_id")
   private Role toRole;



    public UUID getId() {
        return id;
    }



    public void setId(UUID id) {
        this.id = id;
    }



    public Role getFromRole() {
        return fromRole;
    }



    public void setFromRole(Role fromRole) {
        this.fromRole = fromRole;
    }



    public Role getToRole() {
        return toRole;
    }



    public void setToRole(Role toRole) {
        this.toRole = toRole;
    }



    

    



    }

    

    
