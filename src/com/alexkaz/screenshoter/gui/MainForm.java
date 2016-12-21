package com.alexkaz.screenshoter.gui;

import com.alexkaz.screenshoter.utils.PropertyUtils;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainForm extends JFrame {

    public MainForm(){
        super("Screenshoter v1.0");
        setSize(450,275);
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

        distPanel.setPath(PropertyUtils.load(PropertyUtils.path));
        namePanel.selectCheckbox(Boolean.valueOf(PropertyUtils.load(PropertyUtils.checked)));
        namePanel.setPrefix(PropertyUtils.load(PropertyUtils.prefixName));
        intPanel.setHours(PropertyUtils.load(PropertyUtils.hours));
        intPanel.setMinutes(PropertyUtils.load(PropertyUtils.minutes));

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.add(distPanel);
        mainPanel.add(namePanel);
        mainPanel.add(intPanel);
        mainPanel.add(controlPanel);
        mainPanel.setBackground(Color.GRAY);
        setContentPane(mainPanel);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                controlPanel.saveProperties();
                super.windowClosing(e);
            }
        });
    }
}
