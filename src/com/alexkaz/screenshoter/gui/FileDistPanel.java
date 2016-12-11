package com.alexkaz.screenshoter.gui;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FileDistPanel extends JPanel {
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
        Border blackline = BorderFactory.createLineBorder(Color.black);
        TitledBorder border = BorderFactory.createTitledBorder(blackline,"1. Choose the file destination:");
        setBorder(border);
    }

    private void initComps() {
        folderIcon = new JLabel("||");
        folderIcon.setBorder(BorderFactory.createLineBorder(Color.black));
        folderIcon.setSize(20,20);
        folderIcon.setLocation(10,30);
        add(folderIcon);

        textField = new JTextField("C:\\Users\\sasha\\Documents");
        textField.setSize(370,20);
        textField.setLocation(40,30);
        add(textField);

        button = new JButton("Change directory");
        button.setSize(140,20);
        button.setLocation(420,30);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser dirChooser = new JFileChooser();
                dirChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                dirChooser.setDialogTitle("Choose directory for screenshots saving");
                int result = dirChooser.showDialog(null,"Choose");
                if(result == JFileChooser.APPROVE_OPTION){
                    textField.setText(dirChooser.getSelectedFile().getAbsolutePath());
                }
            }
        });
        add(button);
    }
}
