package com.alexkaz.screenshoter.utils;

import javax.imageio.ImageIO;
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
        count = Integer.parseInt(PropertyUtils.load(PropertyUtils.count));
    }

    @Override
    public void run() {
        while (flag){
            try {
                BufferedImage bufferedImage = grabScreen();
                if (bufferedImage != null){
                    ImageIO.write(bufferedImage, "png", new File(destFolder,selectName() + ".png"));
                }
                Thread.sleep(delay);
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
                System.out.println("Image cannot be saved !");
            }
        }
    }

    private String selectName(){
        if (namePrefix.equals("By date")){
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm");
            return dateFormat.format(new Date());
        } else {
            String result = namePrefix + count;
            count++;
            PropertyUtils.update(PropertyUtils.count,count+"");
            return result;
        }
    }

    private BufferedImage grabScreen(){
        try {
            return new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        } catch (SecurityException | AWTException e) {
            e.printStackTrace();
            System.out.println("Screen cannot be grabbed !");
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
