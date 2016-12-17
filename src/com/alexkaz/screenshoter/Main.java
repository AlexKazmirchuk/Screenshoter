package com.alexkaz.screenshoter;

import com.alexkaz.screenshoter.gui.MainForm;
import com.alexkaz.screenshoter.utils.PropertyUtils;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        if (!PropertyUtils.isPropFileExists()) {
            PropertyUtils.create();
        }
        SwingUtilities.invokeLater(() -> new MainForm());
    }
}
