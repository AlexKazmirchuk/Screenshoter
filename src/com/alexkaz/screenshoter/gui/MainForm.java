package com.alexkaz.screenshoter.gui;

import javax.swing.*;

public class MainForm extends JFrame {

    public MainForm(){
        super("Screenshoter v1.0");
        setSize(600,360);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addPanels();
        setVisible(true);
    }

    private void addPanels(){
        FileDistPanel distPanel = new FileDistPanel(0,"1. Choose the file destination:");
        PropertyNamePanel namePanel = new PropertyNamePanel(1,"2. Select file name:");
        RepeatIntPanel intPanel = new RepeatIntPanel(2,"3. Make screenshot every:");
        ControlPanel controlPanel = new ControlPanel(3,"4. Launch or stop:");
        controlPanel.setControlComps(distPanel,namePanel,intPanel);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.add(distPanel);
        mainPanel.add(namePanel);
        mainPanel.add(intPanel);
        mainPanel.add(controlPanel);
        setContentPane(mainPanel);
    }
}
