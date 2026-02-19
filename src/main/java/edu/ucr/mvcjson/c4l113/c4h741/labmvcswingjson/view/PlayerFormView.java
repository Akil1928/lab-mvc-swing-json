package edu.ucr.mvcjson.c4l113.c4h741.labmvcswingjson.view;


import edu.ucr.mvcjson.c4l113.c4h741.labmvcswingjson.controller.PlayerController;
import edu.ucr.mvcjson.c4l113.c4h741.labmvcswingjson.model.Sport;

import javax.swing.*;
import java.awt.*;

/**
 * Main Swing form for registering a new player.
 * Receives the controller via constructor; never accesses the repository directly.
 */
public class PlayerFormView extends JFrame {

    private final PlayerController controller;

    // ── Form fields (max 4) ───────────────────────────────────────────────────
    private final JTextField nameField       = new JTextField(20);
    private final JComboBox<Sport> sportBox  = new JComboBox<>(Sport.values());
    private final JTextField positionField   = new JTextField(20);
    private final JTextField shirtField      = new JTextField(20);

    /**
     * Builds the registration form.
     *
     * @param controller the controller that handles business logic and persistence
     */
    public PlayerFormView(PlayerController controller) {
        this.controller = controller;

        setTitle("Player Registration");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        // ── Form panel ────────────────────────────────────────────────────────
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBorder(BorderFactory.createEmptyBorder(16, 20, 8, 20));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6, 6, 6, 6);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Row 0 – Name
        gbc.gridx = 0; gbc.gridy = 0;
        formPanel.add(new JLabel("Name:"), gbc);
        gbc.gridx = 1;
        formPanel.add(nameField, gbc);

        // Row 1 – Sport
        gbc.gridx = 0; gbc.gridy = 1;
        formPanel.add(new JLabel("Sport:"), gbc);
        gbc.gridx = 1;
        formPanel.add(sportBox, gbc);

        // Row 2 – Position
        gbc.gridx = 0; gbc.gridy = 2;
        formPanel.add(new JLabel("Position:"), gbc);
        gbc.gridx = 1;
        formPanel.add(positionField, gbc);

        // Row 3 – Shirt Number
        gbc.gridx = 0; gbc.gridy = 3;
        formPanel.add(new JLabel("Shirt Number:"), gbc);
        gbc.gridx = 1;
        formPanel.add(shirtField, gbc);

        // ── Button panel ──────────────────────────────────────────────────────
        JButton saveButton = new JButton("Save");
        JButton listButton = new JButton("View Players");

        saveButton.addActionListener(e -> handleSave());
        listButton.addActionListener(e -> openListView());

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 12, 8));
        buttonPanel.add(saveButton);
        buttonPanel.add(listButton);

        // ── Main layout ───────────────────────────────────────────────────────
        setLayout(new BorderLayout());
        add(formPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
    }

    /**
     * Reads the form fields, delegates to the controller, and gives user feedback.
     */
    private void handleSave() {
        String name        = nameField.getText();
        Sport  sport       = (Sport) sportBox.getSelectedItem();
        String position    = positionField.getText();
        String shirtNumber = shirtField.getText();

        try {
            controller.registerPlayer(name, sport, position, shirtNumber);
            JOptionPane.showMessageDialog(
                    this,
                    "Player registered successfully!",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE
            );
            clearFields();
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(
                    this,
                    ex.getMessage(),
                    "Validation Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    /**
     * Opens the secondary window that lists all registered players.
     */
    private void openListView() {
        PlayerListView listView = new PlayerListView(controller);
        listView.setVisible(true);
    }

    /** Resets all input fields to their default (empty) state. */
    private void clearFields() {
        nameField.setText("");
        sportBox.setSelectedIndex(0);
        positionField.setText("");
        shirtField.setText("");
    }
}
