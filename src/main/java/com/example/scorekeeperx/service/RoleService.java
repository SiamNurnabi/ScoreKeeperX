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
            Role parentRole = role.getParentRole();
            role.setLeftCost(parentRole.getLeftCost() + 1);
            role.setRightCost(role.getLeftCost() + 1);
            parentRole.setRightCost(role.getRightCost() + 1);
            recalculate(parentRole);
        } else {
            role.setLeftCost(1);
            role.setRightCost(2);
            entityManager.persist(role);
        }
    }

    public void recalculate(Role parentRole) {
        Integer parentRoleId = parentRole.getId();
        List<Role> roles = getRoleList();

    }

    public void update() {

    }

    public List<Role> getRoleList() {
        return entityManager.createQuery("SELECT r FROM Role r", Role.class).getResultList();
    }

    public List<Role> getUpdatableRoleList(Integer roleId) {
        return entityManager.createQuery("SELECT r FROM Role r WHERE r.", Role.class).getResultList();
    }
}
