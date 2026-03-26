package com.fittrackpro.ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import com.fittrackpro.Storage.DataStore;
import com.fittrackpro.model.ExerciseLog;
import com.fittrackpro.model.BodyWeightLog;

public class ProgressFrame extends JFrame {
    public ProgressFrame() {
        setTitle("FitTrack Pro - Progress");
        setSize(700, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTabbedPane tabbedPane = new JTabbedPane();

        // Workout table
        String[] workoutColumns = {"Exercise", "Sets", "Reps", "Weight (kg)"};
        DefaultTableModel workoutModel = new DefaultTableModel(workoutColumns, 0);

        for (ExerciseLog log : DataStore.getInstance().getExerciseLogs()) {
            workoutModel.addRow(new Object[]{
                log.getExerciseName(),
                log.getSets(),
                log.getReps(),
                log.getWeight()
            });
        }

        JTable workoutTable = new JTable(workoutModel);
        JScrollPane workoutScroll = new JScrollPane(workoutTable);

        // Body weight table
        String[] bodyWeightColumns = {"Date", "Body Weight (kg)"};
        DefaultTableModel bodyWeightModel = new DefaultTableModel(bodyWeightColumns, 0);

        for (BodyWeightLog log : DataStore.getInstance().getBodyWeightLogs()) {
            bodyWeightModel.addRow(new Object[]{
                log.getDate(),
                log.getBodyWeight()
            });
        }

        JTable bodyWeightTable = new JTable(bodyWeightModel);
        JScrollPane bodyWeightScroll = new JScrollPane(bodyWeightTable);

        tabbedPane.addTab("Workout Logs", workoutScroll);
        tabbedPane.addTab("Body Weight Logs", bodyWeightScroll);

        add(tabbedPane, BorderLayout.CENTER);

        setVisible(true);
    }
}