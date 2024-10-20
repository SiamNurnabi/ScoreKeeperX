package com.example.scorekeeperx.service;

import com.example.scorekeeperx.model.Role;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class RoleService {
    @PersistenceContext
    EntityManager entityManager;

    public void createRole(Role role) {
        if (role.getParentRole() != null) {

        } else {
            entityManager.persist(role);
        }
    }

    public void update() {

    }

//    public void update() {
//
//    }

    public List<Role> getRoleList() {
        return entityManager.createQuery("SELECT r FROM Role r", Role.class).getResultList();
    }
}
