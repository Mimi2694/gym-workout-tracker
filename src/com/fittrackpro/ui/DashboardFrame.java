package com.fittrackpro.ui;

import javax.swing.*;
import java.awt.*;

public class DashboardFrame extends JFrame {
    public DashboardFrame() {
        setTitle("FitTrack Pro - Dashboard");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(4, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JButton workoutButton = new JButton("Add Workout Log");
        JButton bodyWeightButton = new JButton("Add Body Weight");
        JButton progressButton = new JButton("View Progress");
        JButton logoutButton = new JButton("Logout");

        panel.add(workoutButton);
        panel.add(bodyWeightButton);
        panel.add(progressButton);
        panel.add(logoutButton);

        add(panel);

        workoutButton.addActionListener(e -> new WorkoutFrame());
        bodyWeightButton.addActionListener(e -> new BodyWeightFrame());
        progressButton.addActionListener(e -> new ProgressFrame());
        logoutButton.addActionListener(e -> {
            new LoginFrame();
            dispose();
        });

        setVisible(true);
    }
}