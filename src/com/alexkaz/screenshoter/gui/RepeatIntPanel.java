package com.alexkaz.screenshoter.gui;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class RepeatIntPanel extends JPanel {
    private JFormattedTextField hours;
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
        Border blackline = BorderFactory.createLineBorder(Color.black);
        TitledBorder border = BorderFactory.createTitledBorder(blackline,"3. Make screenshot every:");
        setBorder(border);
    }

    private void initComps() {
        NumberFormat format = NumberFormat.getInstance();
        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setValueClass(Integer.class);
        formatter.setMinimum(0);
        formatter.setMaximum(99);
        formatter.setAllowsInvalid(false);
        formatter.setCommitsOnValidEdit(false);
        hours = new JFormattedTextField(formatter);
        hours.setSize(30,20);
        hours.setLocation(180,30);
        add(hours);

        hrsLabel = new JLabel("hours");
        hrsLabel.setBorder(BorderFactory.createLineBorder(Color.black));
        hrsLabel.setSize(50,20);
        hrsLabel.setLocation(220,30);
        add(hrsLabel);

        minutes = new JTextField("0");
        minutes.setSize(30,20);
        minutes.setLocation(280,30);
        add(minutes);

        minLabel = new JLabel("minutes");
        minLabel.setBorder(BorderFactory.createLineBorder(Color.black));
        minLabel.setSize(50,20);
        minLabel.setLocation(320,30);
        add(minLabel);
    }
}
