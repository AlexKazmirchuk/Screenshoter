package com.alexkaz.screenshoter.gui;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;

public abstract class AbstractPanel extends JPanel {

    public AbstractPanel(int position, String name) {
        setParams(position, name);
        initComps();
    }

    protected void setParams(int position, String name) {
        setBackground(Color.LIGHT_GRAY);
        setLocation(10,10 + position*80);
        setSize(435,70);
        setLayout(null);
        Border blackline = BorderFactory.createLineBorder(Color.black);
        TitledBorder border = BorderFactory.createTitledBorder(blackline,name);
        setBorder(border);
    }

    protected abstract void initComps();

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        for (Component c: getComponents()){
            c.setEnabled(enabled);
        }
    }
}
