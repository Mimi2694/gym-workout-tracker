package com.fittrackpro;

import javax.swing.SwingUtilities;
import com.fittrackpro.ui.LoginFrame;

public class MainApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginFrame());
    }
}