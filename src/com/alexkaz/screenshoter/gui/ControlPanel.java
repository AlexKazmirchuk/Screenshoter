package com.alexkaz.screenshoter.gui;

import com.alexkaz.screenshoter.utils.Screenshoter;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlPanel extends AbstractPanel {

    private JButton start;
    private JButton stop;
    private Screenshoter screenshoter;

    private FileDistPanel distPanel;
    private PropertyNamePanel namePanel;
    private RepeatIntPanel repeatPanel;

    public ControlPanel(int position, String name) {//4. Launch or stop:
        super(position,name);
    }

    protected void initComps() {
        start = new JButton("Start");
        start.setSize(140,40);
        start.setLocation(70,20);
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                screenshoter = new Screenshoter("D:\\screens","ddfd",5000);
                screenshoter = new Screenshoter(distPanel.getPath()
                                               ,namePanel.getName()
                                               ,repeatPanel.getInterval());
//                new Thread(screenshoter).start();
                enableGUI(false);
                start.setEnabled(false);
                stop.setEnabled(true);
            }
        });
        add(start);

        stop = new JButton("Stop");
        stop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(screenshoter !=null)
                    screenshoter.setFlag(false);
                enableGUI(true);
                start.setEnabled(true);
                stop.setEnabled(false);
            }
        });
        stop.setSize(140,40);
        stop.setLocation(230,20);
        stop.setEnabled(false);
        add(stop);
    }

    public void setControlComps(FileDistPanel distPanel,PropertyNamePanel namePanel, RepeatIntPanel repeatPanel){
        this.distPanel = distPanel;
        this.namePanel = namePanel;
        this.repeatPanel = repeatPanel;
    }

    private void enableGUI(boolean enabled){
            distPanel.setEnabled(enabled);
            namePanel.setEnabled(enabled);
            repeatPanel.setEnabled(enabled);
    }
}
