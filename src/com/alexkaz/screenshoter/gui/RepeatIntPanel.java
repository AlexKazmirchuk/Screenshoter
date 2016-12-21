package com.alexkaz.screenshoter.gui;

import com.alexkaz.screenshoter.utils.NumericAndLengthFilter;

import javax.swing.*;
import javax.swing.text.AbstractDocument;
import java.awt.*;

public class RepeatIntPanel extends AbstractPanel {
    private JTextField hours;
    private JLabel hrsLabel;
    private JTextField minutes;
    private JLabel minLabel;

    public RepeatIntPanel(int position,String name) {//3. Make screenshot every:
        super(position,name);
    }

    protected void initComps() {
        hours = new JTextField("");
        hours.setHorizontalAlignment(SwingConstants.CENTER);
        ((AbstractDocument) hours.getDocument()).setDocumentFilter(new NumericAndLengthFilter(2));
        hours.setSize(30,20);
        hours.setLocation(120,23);
        add(hours);

        hrsLabel = new JLabel("hours");
        hrsLabel.setSize(40,20);
        hrsLabel.setLocation(155,23);
        add(hrsLabel);

        minutes = new JTextField("");
        minutes.setHorizontalAlignment(SwingConstants.CENTER);
        ((AbstractDocument) minutes.getDocument()).setDocumentFilter(new NumericAndLengthFilter(2));
        minutes.setSize(30,20);
        minutes.setLocation(200,23);
        add(minutes);

        minLabel = new JLabel("minutes");
        minLabel.setSize(50,20);
        minLabel.setLocation(235,23);
        add(minLabel);
    }

    public int getInterval(){
        int hours = (!this.hours.getText().equals(""))  ?  Integer.parseInt(this.hours.getText())  :  0;
        int minutes = (!this.minutes.getText().equals(""))  ?  Integer.parseInt(this.minutes.getText())  :  0;
        return (hours * 1000 * 60 * 60) + (minutes * 1000 * 60);
    }

    public String getHours(){
        return hours.getText();
    }

    public String getMinutes(){
        return minutes.getText();
    }

    public void setHours(String value){
        hours.setText(value);
    }

    public void setMinutes(String value){
        minutes.setText(value);
    }
}
