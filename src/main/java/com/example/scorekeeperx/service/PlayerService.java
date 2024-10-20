package com.example.scorekeeperx.service;

import com.example.scorekeeperx.model.Player;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class PlayerService {
    @PersistenceContext
    EntityManager entityManager;

    public void create(Player player) {
        entityManager.persist(player);
    }

    public Player update(Player player) {
        return entityManager.merge(player);
    }

    public void delete(Player player) {
        entityManager.remove(player);
    }


    public List<Player> getPlayerList() {
        return entityManager.createQuery("SELECT p FROM Player p", Player.class).getResultList();
    }
}
