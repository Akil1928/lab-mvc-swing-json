package edu.ucr.mvcjson.c4l113.c4h741.labmvcswingjson;

import edu.ucr.mvcjson.c4l113.c4h741.labmvcswingjson.controller.PlayerController;
import edu.ucr.mvcjson.c4l113.c4h741.labmvcswingjson.repository.JsonPlayerRepository;
import edu.ucr.mvcjson.c4l113.c4h741.labmvcswingjson.repository.PlayerRepository;
import edu.ucr.mvcjson.c4l113.c4h741.labmvcswingjson.view.PlayerFormView;

import javax.swing.*;

/**
 * Application entry point.
 * Assembles the MVC layers using constructor injection and launches the UI.
 */
public class Main {

    public static void main(String[] args) {
        // 1. Create the repository (JSON implementation of the interface)
        PlayerRepository repository = new JsonPlayerRepository();

        // 2. Inject the repository into the controller
        PlayerController controller = new PlayerController(repository);

        // 3. Inject the controller into the view and show it on the EDT
        SwingUtilities.invokeLater(() -> {
            PlayerFormView form = new PlayerFormView(controller);
            form.setVisible(true);
        });
    }
}
