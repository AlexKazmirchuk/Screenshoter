package com.alexkaz.screenshoter.gui;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileDistPanel extends AbstractPanel {
    private JLabel folderIcon;
    private JTextField textField;
    private JButton button;

    public FileDistPanel(int position,String name) {
        super(position,name);
    }

    protected void initComps() {
        folderIcon = new JLabel("||");
        folderIcon.setBorder(BorderFactory.createLineBorder(Color.black));
        folderIcon.setSize(20,20);
        folderIcon.setLocation(10,30);
        add(folderIcon);

        textField = new JTextField("");
        textField.setSize(230,20);
        textField.setLocation(40,30);
        add(textField);

        button = new JButton("Change directory");
        button.setSize(140,20);
        button.setLocation(280,30);
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

    public String getPath(){
        if (textField.getText().equals("")){
            return "";
        }
        try {
            String result = Paths.get(textField.getText()).toRealPath().toString();
            if(Files.isDirectory(Paths.get(result)) && !result.equals("")){
                return result;
            } else {
                return "";
            }
        } catch (InvalidPathException e){
            System.out.println("Path is invalid");
            return "";
        } catch (IOException e) {
            System.out.println("IO exception in FileDistPanel");
            return "";
        }
    }

    public void setPath(String path){
        textField.setText(path);
    }
}
