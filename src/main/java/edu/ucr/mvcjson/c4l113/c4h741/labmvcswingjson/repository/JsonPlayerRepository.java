package edu.ucr.mvcjson.c4l113.c4h741.labmvcswingjson.repository;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.ucr.mvcjson.c4l113.c4h741.labmvcswingjson.model.Player;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JsonPlayerRepository implements PlayerRepository {

    private static final String FILE_PATH = "data/players.json";

    private final ObjectMapper mapper = new ObjectMapper();
    private final List<Player> players = new ArrayList<>();

    /**
     * Constructs the repository and loads any existing players from disk.
     * If the file does not exist, the repository starts empty.
     */
    public JsonPlayerRepository() {
        loadFromDisk();
    }

    // ── PlayerRepository ─────────────────────────────────────────────────────

    @Override
    public void save(Player player) {
        players.add(player);
        persistToDisk();
    }

    @Override
    public List<Player> findAll() {
        return Collections.unmodifiableList(players);
    }

    // ── Private helpers ───────────────────────────────────────────────────────

    /**
     * Reads the JSON file from disk and populates the in-memory list.
     * Silently skips loading if the file does not exist.
     */
    private void loadFromDisk() {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            return; // nothing to load on first run
        }
        try {
            List<Player> loaded = mapper.readValue(file, new TypeReference<List<Player>>() {});
            players.addAll(loaded);
            System.out.println("Loaded " + players.size() + " player(s) from " + FILE_PATH);
        } catch (IOException e) {
            System.err.println("Warning: could not load " + FILE_PATH + " – " + e.getMessage());
        }
    }

    /**
     * Writes the full in-memory list to disk as a JSON array.
     * Creates the {@code data/} directory if it does not exist.
     */
    private void persistToDisk() {
        File file = new File(FILE_PATH);
        file.getParentFile().mkdirs(); // ensure data/ directory exists
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(file, players);
        } catch (IOException e) {
            System.err.println("Error: could not write " + FILE_PATH + " – " + e.getMessage());
        }
    }
}
