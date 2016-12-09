package com.alexkaz.screenshoter;

import javax.swing.*;
import java.awt.*;

public class FileDistPanel extends JPanel {

    private JLabel title;
    private JLabel folderIcon;
    private JTextField textField;
    private JButton button;

    public FileDistPanel() {
        setParams();
        initComps();
    }

    private void setParams() {
        setBackground(Color.CYAN);
        setLocation(10,10);
        setSize(575,70);
        setLayout(null);
    }

    private void initComps() {
        title = new JLabel("1. Choose the file destination:");
        title.setBorder(BorderFactory.createLineBorder(Color.black));
        title.setSize(550,20);
        title.setLocation(10,10);
        add(title);

        folderIcon = new JLabel("||");
        folderIcon.setBorder(BorderFactory.createLineBorder(Color.black));
        folderIcon.setSize(20,20);
        folderIcon.setLocation(10,40);
        add(folderIcon);

        textField = new JTextField("C://Users/");
        textField.setSize(370,20);
        textField.setLocation(40,40);
        add(textField);

        button = new JButton("Change directory");
        button.setSize(140,20);
        button.setLocation(420,40);
        add(button);
    }
}
