package com.alexkaz.screenshoter.gui;

import com.alexkaz.screenshoter.utils.NumericAndLengthFilter;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.text.AbstractDocument;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class RepeatIntPanel extends AbstractPanel {
    private JTextField hours;
    private JLabel hrsLabel;
    private JTextField minutes;
    private JLabel minLabel;

    public RepeatIntPanel(int position,String name) {//3. Make screenshot every:
        super(position,name);
    }

    protected void initComps() {
        hours = new JTextField("0");
        ((AbstractDocument) hours.getDocument()).setDocumentFilter(new NumericAndLengthFilter(2));
        hours.setSize(30,20);
        hours.setLocation(180,30);
        add(hours);

        hrsLabel = new JLabel("hours");
        hrsLabel.setBorder(BorderFactory.createLineBorder(Color.black));
        hrsLabel.setSize(50,20);
        hrsLabel.setLocation(220,30);
        add(hrsLabel);

        minutes = new JTextField("0");
        ((AbstractDocument) minutes.getDocument()).setDocumentFilter(new NumericAndLengthFilter(2));
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
