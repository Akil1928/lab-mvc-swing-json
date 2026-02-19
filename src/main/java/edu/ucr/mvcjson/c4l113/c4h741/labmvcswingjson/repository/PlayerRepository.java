package edu.ucr.mvcjson.c4l113.c4h741.labmvcswingjson.repository;

import edu.ucr.mvcjson.c4l113.c4h741.labmvcswingjson.model.Player;

import java.util.List;


public interface PlayerRepository {


    void save(Player player);

    List<Player> findAll();
}
