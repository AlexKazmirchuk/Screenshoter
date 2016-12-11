package com.alexkaz.screenshoter.gui;

import com.alexkaz.screenshoter.utils.Screenshoter;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllPanel extends AbstractPanel {
    private JButton start;
    private JButton stop;
    private Screenshoter screenshoter;

    public ControllPanel(int position,String name) {//4. Launch or stop:
        super(position,name);
    }

    protected void initComps() {
        start = new JButton("Start");
        start.setSize(200,40);
        start.setLocation(100,20);
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                screenshoter = new Screenshoter("D:\\screens",5000,"ddfd");
                new Thread(screenshoter).start();
            }
        });
        add(start);

        stop = new JButton("Stop");
        stop.setSize(200,40);
        stop.setLocation(310,20);
        add(stop);
    }
}
