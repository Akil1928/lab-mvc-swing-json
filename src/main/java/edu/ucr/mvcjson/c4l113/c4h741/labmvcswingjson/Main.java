package edu.ucr.mvcjson.c4l113.c4h741.labmvcswingjson;

import edu.ucr.mvcjson.c4l113.c4h741.labmvcswingjson.controller.PlayerController;
import edu.ucr.mvcjson.c4l113.c4h741.labmvcswingjson.repository.JsonPlayerRepository;
import edu.ucr.mvcjson.c4l113.c4h741.labmvcswingjson.repository.PlayerRepository;
import edu.ucr.mvcjson.c4l113.c4h741.labmvcswingjson.view.PlayerFormView;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        PlayerRepository repository = new JsonPlayerRepository();

        PlayerController controller = new PlayerController(repository);

        SwingUtilities.invokeLater(() -> {
            PlayerFormView form = new PlayerFormView(controller);
            form.setVisible(true);
        });
    }
}
