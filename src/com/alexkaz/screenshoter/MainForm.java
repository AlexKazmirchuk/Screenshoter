package com.alexkaz.screenshoter;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MainForm extends JFrame {

    MainForm(){
        super("Screenshoter v1.0");
        setSize(600,395);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addPanels();
        setVisible(true);
    }

    private void addPanels(){
        FileDistPanel jPanel1 = new FileDistPanel();
        PropertyNamePanel namePanel = new PropertyNamePanel();
        RepeatIntPanel intPanel = new RepeatIntPanel();
        ControllPanel controllPanel = new ControllPanel();

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.add(jPanel1);
        mainPanel.add(namePanel);
        mainPanel.add(intPanel);
        mainPanel.add(controllPanel);
        setContentPane(mainPanel);
    }
}
