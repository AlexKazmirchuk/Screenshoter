package com.alexkaz.screenshoter.utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Screenshoter implements Runnable {
    private String destFolder;
    private int delay;
    private String namePrefix;
    private boolean flag = true;
    private int count = 0;

    public Screenshoter(String destFolder, int delay, String namePrefix) {
        this.destFolder = destFolder;
        this.delay = delay;
        this.namePrefix = namePrefix;
    }

    @Override
    public void run() {
        while (flag){
            try {
                BufferedImage bufferedImage = grabScreen();
                if (bufferedImage != null){
                    ImageIO.write(bufferedImage,"png",new File(destFolder,namePrefix+count+".png"));
                    count++;
                }
                Thread.sleep(delay);
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
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
