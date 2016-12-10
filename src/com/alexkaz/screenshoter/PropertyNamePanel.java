package com.alexkaz.screenshoter;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PropertyNamePanel extends JPanel {
    private JLabel byDateL;
    private JCheckBox checkBox;
    private JLabel orLabel;
    private JTextField textField;
    private JLabel fileExtLabel;


    public PropertyNamePanel() {
        setParams();
        addComps();
    }

    private void setParams() {
        setBackground(Color.YELLOW);
        setLocation(10,90);
        setSize(575,70);
        setLayout(null);
        Border blackline = BorderFactory.createLineBorder(Color.black);
        TitledBorder border = BorderFactory.createTitledBorder(blackline,"2. Select file name:");
        setBorder(border);
    }

    private void addComps() {

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
        });
        add(checkBox);

        orLabel = new JLabel("or");
        orLabel.setBorder(BorderFactory.createLineBorder(Color.black));
        orLabel.setSize(20,20);
        orLabel.setLocation(100,30);
        orLabel.setEnabled(false);
        add(orLabel);

        textField = new JTextField("screenshoot");
        textField.setSize(350,20);
        textField.setLocation(130,30);
        textField.setEnabled(false);
        add(textField);

        fileExtLabel = new JLabel("(count).jpg");
        fileExtLabel.setBorder(BorderFactory.createLineBorder(Color.black));
        fileExtLabel.setSize(70,20);
        fileExtLabel.setLocation(490,30);
        fileExtLabel.setEnabled(false);
        add(fileExtLabel);
    }
}
