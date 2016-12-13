package com.alexkaz.screenshoter.gui;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PropertyNamePanel extends AbstractPanel {
    private JLabel byDateL;
    private JCheckBox checkBox;
    private JLabel orLabel;
    private JTextField textField;
    private JLabel fileExtLabel;

    public PropertyNamePanel(int position,String name) {
        super(position,name);
    }

    protected void initComps() {

        byDateL = new JLabel("By date:");
        byDateL.setBorder(BorderFactory.createLineBorder(Color.black));
        byDateL.setSize(50,20);
        byDateL.setLocation(10,30);
        add(byDateL);

        checkBox = new JCheckBox();
        checkBox.setSize(20,20);
        checkBox.setLocation(70,30);
        checkBox.setSelected(true);
        checkBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchComponents();
            }
        });
        add(checkBox);

        orLabel = new JLabel("or");
        orLabel.setBorder(BorderFactory.createLineBorder(Color.black));
        orLabel.setSize(20,20);
        orLabel.setLocation(100,30);
        orLabel.setEnabled(false);
        add(orLabel);

        textField = new JTextField("screenshoot");
        textField.setSize(210,20);
        textField.setLocation(130,30);
        textField.setEnabled(false);
        add(textField);

        fileExtLabel = new JLabel("(count).jpg");
        fileExtLabel.setBorder(BorderFactory.createLineBorder(Color.black));
        fileExtLabel.setSize(70,20);
        fileExtLabel.setLocation(350,30);
        fileExtLabel.setEnabled(false);
        add(fileExtLabel);
    }

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        switchComponents();
    }

    private void switchComponents(){
        if(checkBox.isSelected()){
            byDateL.setEnabled(true);
            orLabel.setEnabled(false);
            textField.setEnabled(false);
            fileExtLabel.setEnabled(false);
        } else{
            byDateL.setEnabled(false);
            orLabel.setEnabled(true);
            textField.setEnabled(true);
            fileExtLabel.setEnabled(true);
        }
    }
}
