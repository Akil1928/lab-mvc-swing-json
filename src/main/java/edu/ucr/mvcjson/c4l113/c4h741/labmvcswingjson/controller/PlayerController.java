package edu.ucr.mvcjson.c4l113.c4h741.labmvcswingjson.controller;

import edu.ucr.mvcjson.c4l113.c4h741.labmvcswingjson.model.Player;
import edu.ucr.mvcjson.c4l113.c4h741.labmvcswingjson.model.Sport;
import edu.ucr.mvcjson.c4l113.c4h741.labmvcswingjson.repository.PlayerRepository;


import java.util.List;


public class PlayerController {

    private final PlayerRepository repository;


    public PlayerController(PlayerRepository repository) {
        this.repository = repository;
    }


    public void registerPlayer(String name, Sport sport, String position, String shirtNumber) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name must not be empty.");
        }

        if (sport == null) {
            throw new IllegalArgumentException("Sport must be selected.");
        }

        int number;
        try {
            number = Integer.parseInt(shirtNumber.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Shirt number must be a valid integer.");
        }
        if (number <= 0) {
            throw new IllegalArgumentException("Shirt number must be greater than 0.");
        }

        Player player = new Player(name.trim(), sport, position.trim(), number);
        repository.save(player);
    }

    public List<Player> getAllPlayers() {
        return repository.findAll();
    }
}
