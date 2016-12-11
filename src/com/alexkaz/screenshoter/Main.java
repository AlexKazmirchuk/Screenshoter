package com.alexkaz.screenshoter;

import com.alexkaz.screenshoter.gui.MainForm;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainForm());
    }
}
