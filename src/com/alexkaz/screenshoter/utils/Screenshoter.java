package com.alexkaz.screenshoter.utils;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Screenshoter implements Runnable {
    private String destFolder;
    private int delay;
    private String namePrefix;
    private boolean flag = true;
    private int count = 0;

    public Screenshoter(String destFolder,String namePrefix, int delay) {
        this.destFolder = destFolder;
        this.namePrefix = namePrefix;
        this.delay = delay;
        System.out.println("path " + destFolder);
        System.out.println("prefix " + namePrefix);
        System.out.println("delay " + delay);
    }

    @Override
    public void run() {
        while (flag){
            try {
                BufferedImage bufferedImage = grabScreen();
                if (bufferedImage != null){
//                    ImageIO.write(bufferedImage,"png",new File(destFolder,namePrefix+count+".png"));
                    ImageIO.write(bufferedImage, "png", new File(destFolder,selectName() + ".png"));
                    count++;
                }
                Thread.sleep(delay);
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private String selectName(){
        if (namePrefix.equals("By date")){
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm");
            return dateFormat.format(new Date());
        } else {
            return namePrefix+count;
        }
    }

    private BufferedImage grabScreen(){
        try {
            return new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        } catch (SecurityException | AWTException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
