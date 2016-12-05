package com.alexkaz.screenshoter;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MainForm extends JFrame {

    MainForm(){
        super("Screenshoter v1.0");
        setSize(600,395);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        addPanels();
    }

    private void addPanels(){
        JPanel mainPanel = new JPanel();
        JPanel jPanel1 = new JPanel();
        JPanel jPanel2 = new JPanel();
        JPanel jPanel3 = new JPanel();
        JPanel jPanel4 = new JPanel();

        jPanel1.setBackground(Color.CYAN);
        jPanel2.setBackground(Color.ORANGE);
        jPanel3.setBackground(Color.BLUE);
        jPanel4.setBackground(Color.RED);

        mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));
        mainPanel.add(jPanel1);
        mainPanel.add(Box.createRigidArea(new Dimension(0,15)));
        mainPanel.add(jPanel2);
        mainPanel.add(Box.createRigidArea(new Dimension(0,15)));
        mainPanel.add(jPanel3);
        mainPanel.add(Box.createRigidArea(new Dimension(0,15)));
        mainPanel.add(jPanel4);

        mainPanel.setBorder(new EmptyBorder(20,20,20,20));
        mainPanel.setSize(600,395);
        setContentPane(mainPanel);

    }
}
