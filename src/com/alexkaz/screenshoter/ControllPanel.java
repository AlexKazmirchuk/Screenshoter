package com.alexkaz.screenshoter;

import javax.swing.*;
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
    }

    private void initComps() {
        start = new JButton("Start");
        start.setSize(200,50);
        start.setLocation(100,10);
        add(start);


        stop = new JButton("Stop");
        stop.setSize(200,50);
        stop.setLocation(310,10);
        add(stop);
    }
}
