package com.alexkaz.screenshoter.gui;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class AbstractPanel extends JPanel {

    public AbstractPanel(int position, String name) {
        setParams(position, name);
        initComps();
    }

    protected void setParams(int position, String name) {
        setBackground(Color.CYAN);
        setLocation(10,10 + position*70);
        setSize(575,70);
        setLayout(null);
        Border blackline = BorderFactory.createLineBorder(Color.black);
        TitledBorder border = BorderFactory.createTitledBorder(blackline,name);
        setBorder(border);
    }

    protected abstract void initComps();
}
