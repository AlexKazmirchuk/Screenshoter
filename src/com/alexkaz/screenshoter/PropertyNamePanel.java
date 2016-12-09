package com.alexkaz.screenshoter;

import javax.swing.*;
import java.awt.*;

public class PropertyNamePanel extends JPanel {
    private JLabel title;
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
    }

    private void addComps() {
        title = new JLabel("2. Select file name:");
        title.setBorder(BorderFactory.createLineBorder(Color.black));
        title.setSize(550,20);
        title.setLocation(10,10);
        add(title);

        byDateL = new JLabel("By date:");
        byDateL.setBorder(BorderFactory.createLineBorder(Color.black));
        byDateL.setSize(50,20);
        byDateL.setLocation(10,40);
        add(byDateL);

        checkBox = new JCheckBox();
        checkBox.setSize(20,20);
        checkBox.setLocation(70,40);
        add(checkBox);

        orLabel = new JLabel("or");
        orLabel.setBorder(BorderFactory.createLineBorder(Color.black));
        orLabel.setSize(20,20);
        orLabel.setLocation(100,40);
        add(orLabel);

        textField = new JTextField("screenshoot");
        textField.setSize(350,20);
        textField.setLocation(130,40);
        add(textField);

        fileExtLabel = new JLabel("(count).jpg");
        fileExtLabel.setBorder(BorderFactory.createLineBorder(Color.black));
        fileExtLabel.setSize(70,20);
        fileExtLabel.setLocation(490,40);
        add(fileExtLabel);
    }
}
