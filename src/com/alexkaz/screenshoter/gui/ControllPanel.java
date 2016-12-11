package com.alexkaz.screenshoter.gui;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class ControllPanel extends JPanel {
    private JButton start;
    private JButton stop;

    public ControllPanel() {
        setParams();
        initComps();
    }

    private void setParams() {
        setBackground(Color.RED);
        setLocation(10,250);
        setSize(575,70);
        setLayout(null);
        Border blackline = BorderFactory.createLineBorder(Color.black);
        TitledBorder border = BorderFactory.createTitledBorder(blackline,"4. Launch or stop:");
        setBorder(border);
    }

    private void initComps() {
        start = new JButton("Start");
        start.setSize(200,40);
        start.setLocation(100,20);
        add(start);


        stop = new JButton("Stop");
        stop.setSize(200,40);
        stop.setLocation(310,20);
        add(stop);
    }
}
