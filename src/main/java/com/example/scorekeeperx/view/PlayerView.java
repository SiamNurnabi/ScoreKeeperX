package com.example.scorekeeperx.view;

import com.example.scorekeeperx.model.Player;
import com.example.scorekeeperx.service.PlayerService;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class PlayerView implements Serializable {
    private Player player;
    private List<Player> players;
    private Boolean editMode;

    @Inject
    private PlayerService playerService;

    @PostConstruct
    public void init() {
        players = playerService.getPlayerList();
    }

    public Player getPlayer() {
        return player;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Boolean getEditMode() {
        return editMode;
    }

    public void submit() {
        if (editMode) {
            playerService.update(player);
        } else {
            playerService.create(player);
            players.add(player);
        }
    }

    public void newPlayer() {
        this.player = new Player();
        this.editMode = false;
    }

    public void editPlayer(Player player) {
        this.player = player;
        this.editMode = true;
    }
}
