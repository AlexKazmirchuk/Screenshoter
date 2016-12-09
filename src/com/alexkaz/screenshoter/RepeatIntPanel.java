package com.alexkaz.screenshoter;

import javax.swing.*;
import java.awt.*;

public class RepeatIntPanel extends JPanel {
    private JLabel title;
    private JTextField hours;
    private JLabel hrsLabel;
    private JTextField minutes;
    private JLabel minLabel;

    public RepeatIntPanel() {
        setParams();
        initComps();
    }

    private void setParams() {
        setBackground(Color.BLUE);
        setLocation(10,170);
        setSize(575,70);
        setLayout(null);
    }

    private void initComps() {
        title = new JLabel("3. Make screenshot every:");
        title.setBorder(BorderFactory.createLineBorder(Color.black));
        title.setSize(550,20);
        title.setLocation(10,10);
        add(title);

        hours = new JTextField("0");
        hours.setSize(30,20);
        hours.setLocation(180,40);
        add(hours);

        hrsLabel = new JLabel("hours");
        hrsLabel.setBorder(BorderFactory.createLineBorder(Color.black));
        hrsLabel.setSize(50,20);
        hrsLabel.setLocation(220,40);
        add(hrsLabel);

        minutes = new JTextField("0");
        minutes.setSize(30,20);
        minutes.setLocation(280,40);
        add(minutes);

        minLabel = new JLabel("minutes");
        minLabel.setBorder(BorderFactory.createLineBorder(Color.black));
        minLabel.setSize(50,20);
        minLabel.setLocation(320,40);
        add(minLabel);
    }
}
