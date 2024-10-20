package com.example.scorekeeperx.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "role")
public class Role implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "left_cost", nullable = false)
    private Integer leftCost;

    @Column(name = "right_cost", nullable = false)
    private Integer rightCost;

    @ManyToOne
    @JoinColumn(
            name = "parent_id",
            nullable = false
    )
    private Role parentRole;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getLeftCost() {
        return leftCost;
    }

    public void setLeftCost(Integer leftCost) {
        this.leftCost = leftCost;
    }

    public Integer getRightCost() {
        return rightCost;
    }

    public void setRightCost(Integer rightCost) {
        this.rightCost = rightCost;
    }

    public Role getParentRole() {
        return parentRole;
    }

    public void setParentRole(Role parentRole) {
        this.parentRole = parentRole;
    }
}
