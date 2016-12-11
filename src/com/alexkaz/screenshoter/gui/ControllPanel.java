package com.alexkaz.screenshoter.gui;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class ControllPanel extends AbstractPanel {
    private JButton start;
    private JButton stop;

    public ControllPanel(int position,String name) {//4. Launch or stop:
        super(position,name);
    }

    protected void initComps() {
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
