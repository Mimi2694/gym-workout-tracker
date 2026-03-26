package com.fittrackpro.ui;

import javax.swing.*;
import java.awt.*;
import com.fittrackpro.model.ExerciseLog;
import com.fittrackpro.Storage.DataStore;

public class WorkoutFrame extends JFrame {
    private JTextField exerciseField;
    private JTextField setsField;
    private JTextField repsField;
    private JTextField weightField;
    private JButton saveButton;

    public WorkoutFrame() {
        setTitle("Add Workout Log");
        setSize(400, 280);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        exerciseField = new JTextField();
        setsField = new JTextField();
        repsField = new JTextField();
        weightField = new JTextField();
        saveButton = new JButton("Save");

        panel.add(new JLabel("Exercise Name:"));
        panel.add(exerciseField);
        panel.add(new JLabel("Sets:"));
        panel.add(setsField);
        panel.add(new JLabel("Reps:"));
        panel.add(repsField);
        panel.add(new JLabel("Weight (kg):"));
        panel.add(weightField);
        panel.add(new JLabel());
        panel.add(saveButton);

        add(panel);

        saveButton.addActionListener(e -> saveWorkout());

        setVisible(true);
    }

    private void saveWorkout() {
        try {
            String exercise = exerciseField.getText().trim();
            int sets = Integer.parseInt(setsField.getText().trim());
            int reps = Integer.parseInt(repsField.getText().trim());
            double weight = Double.parseDouble(weightField.getText().trim());

            if (exercise.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Exercise name cannot be empty.");
                return;
            }

            ExerciseLog log = new ExerciseLog(exercise, sets, reps, weight);
            DataStore.getInstance().addExerciseLog(log);

            JOptionPane.showMessageDialog(this, "Workout log saved successfully!");
            dispose();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers.");
        }
    }
}