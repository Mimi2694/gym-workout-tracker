package com.fittrackpro;

import javax.swing.*;

public class MainApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("FitTrack Pro MVP");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton loginBtn = new JButton("Login");
        loginBtn.setBounds(150, 100, 100, 40);
        frame.add(loginBtn);

        loginBtn.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Login clicked!"));

        frame.setLayout(null);
        frame.setVisible(true);
    }
}