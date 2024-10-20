package com.example.scorekeeperx.view;

import com.example.scorekeeperx.model.Player;
import com.example.scorekeeperx.model.Role;
import com.example.scorekeeperx.service.PlayerService;
import com.example.scorekeeperx.service.RoleService;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class RoleView implements Serializable {
    private Role role;
    private List<Role> roles;
    private Boolean editMode;

    @Inject
    private RoleService roleService;

    @PostConstruct
    public void init() {
        roles = roleService.getRoleList();
    }

    public Role getRole() {
        return role;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public Boolean getEditMode() {
        return editMode;
    }

    public void submit() {
        if (editMode) {
            roleService.update();
        } else {
            roleService.createRole(role);
            roles.add(role);
        }
    }

    public void add() {
        this.role = new Role();
        this.editMode = false;
    }

    public void edit(Role role) {
        this.role = role;
        this.editMode = true;
    }
}
