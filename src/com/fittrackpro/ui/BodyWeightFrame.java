package com.fittrackpro.ui;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import com.fittrackpro.model.BodyWeightLog;
import com.fittrackpro.Storage.DataStore;

public class BodyWeightFrame extends JFrame {
    private JTextField dateField;
    private JTextField weightField;
    private JButton saveButton;

    public BodyWeightFrame() {
        setTitle("Add Body Weight");
        setSize(400, 220);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        dateField = new JTextField(LocalDate.now().toString());
        weightField = new JTextField();
        saveButton = new JButton("Save");

        panel.add(new JLabel("Date (YYYY-MM-DD):"));
        panel.add(dateField);
        panel.add(new JLabel("Body Weight (kg):"));
        panel.add(weightField);
        panel.add(new JLabel());
        panel.add(saveButton);

        add(panel);

        saveButton.addActionListener(e -> saveBodyWeight());

        setVisible(true);
    }

    private void saveBodyWeight() {
        try {
            String date = dateField.getText().trim();
            double weight = Double.parseDouble(weightField.getText().trim());

            if (date.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Date cannot be empty.");
                return;
            }

            BodyWeightLog log = new BodyWeightLog(date, weight);
            DataStore.getInstance().addBodyWeightLog(log);

            JOptionPane.showMessageDialog(this, "Body weight saved successfully!");
            dispose();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid body weight.");
        }
    }
}