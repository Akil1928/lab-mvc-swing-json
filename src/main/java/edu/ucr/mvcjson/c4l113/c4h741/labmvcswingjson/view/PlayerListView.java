package edu.ucr.mvcjson.c4l113.c4h741.labmvcswingjson.view;


import edu.ucr.mvcjson.c4l113.c4h741.labmvcswingjson.controller.PlayerController;
import edu.ucr.mvcjson.c4l113.c4h741.labmvcswingjson.model.Player;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class PlayerListView extends JFrame {

    private final PlayerController controller;
    private final DefaultTableModel tableModel;

    public PlayerListView(PlayerController controller) {
        this.controller = controller;

        setTitle("Registered Players");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //table setup
        String[] columns = {"#", "Name", "Sport", "Position", "Shirt Number"};
        tableModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false; // read-only table
            }
        };

        JTable table = new JTable(tableModel);
        table.setRowHeight(24);
        table.getTableHeader().setReorderingAllowed(false);

        JScrollPane scrollPane = new JScrollPane(table);

        //Refresh button
        JButton refreshButton = new JButton("Refresh");
        refreshButton.addActionListener(e -> loadPlayers());

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        bottomPanel.add(refreshButton);

        //Layout
        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        loadPlayers();
    }

    private void loadPlayers() {
        tableModel.setRowCount(0); // clear existing rows
        List<Player> players = controller.getAllPlayers();
        int index = 1;
        for (Player p : players) {
            tableModel.addRow(new Object[]{
                    index++,
                    p.getName(),
                    p.getSport(),
                    p.getPosition(),
                    p.getShirtNumber()
            });
        }
    }
}
