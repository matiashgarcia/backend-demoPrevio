package com.uade.demoPrevio.entity;

import java.util.List;

import com.uade.demoPrevio.enums.RoleType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String lastname;

    @Column(unique = true)
    private String email;
    
    private String password;

    /*
     * @ManyToOne
     * 
     * @JoinColumn(name = "role_id")
     * private Role role;
     */

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @OneToMany(mappedBy = "user")
    private List<Favorite> favorites;

}
