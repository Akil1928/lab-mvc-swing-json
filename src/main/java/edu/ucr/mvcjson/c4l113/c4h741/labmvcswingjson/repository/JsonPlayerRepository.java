package edu.ucr.mvcjson.c4l113.c4h741.labmvcswingjson.repository;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.ucr.mvcjson.c4l113.c4h741.labmvcswingjson.model.Player;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JsonPlayerRepository implements PlayerRepository {

    private static final Path FILE_PATH = Path.of("data", "players.json");

    private static final ObjectMapper MAPPER = new ObjectMapper();
    private static final JavaType PLAYER_LIST_TYPE =
            MAPPER.getTypeFactory().constructCollectionType(List.class, Player.class);

    private final List<Player> players = new ArrayList<>();

    public JsonPlayerRepository() {
        loadFromDisk();
    }

    @Override
    public void save(Player player) {
        players.add(player);
        persistToDisk();
    }

    @Override
    public List<Player> findAll() {
        return Collections.unmodifiableList(players);
    }

    private void loadFromDisk() {
        if (!Files.exists(FILE_PATH)) {
            return;
        }
        try {
            List<Player> loaded = MAPPER.readValue(FILE_PATH.toFile(), PLAYER_LIST_TYPE);
            players.clear();
            players.addAll(loaded);
        } catch (IOException e) {
            System.err.println("Warning: could not load " + FILE_PATH + " – " + e.getMessage());
        }
    }

    private void persistToDisk() {
        try {
            Files.createDirectories(FILE_PATH.getParent());
            MAPPER.writerWithDefaultPrettyPrinter().writeValue(FILE_PATH.toFile(), players);
        } catch (IOException e) {
            System.err.println("Error: could not write " + FILE_PATH + " – " + e.getMessage());
        }
    }
}