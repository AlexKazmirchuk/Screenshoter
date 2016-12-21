package com.alexkaz.screenshoter.utils;

import javax.swing.*;
import java.io.*;
import java.util.Properties;

public class PropertyUtils {
    public static final String path = "path";
    public static final String checked = "checked";
    public static final String prefixName = "prefixName";
    public static final String hours = "hours";
    public static final String minutes = "minutes";
    public static final String count = "count";

    public static void create(){
        String myDocuments = new JFileChooser().getFileSystemView().getDefaultDirectory().toString();
        myDocuments+="\\AutoScreenshoter";
        new File(myDocuments).mkdir();
        try {
            new File(myDocuments+"\\config.prop").createNewFile();
        } catch (IOException e) {
            System.out.println("Property file has not created");
        }
        Properties properties = new Properties();
        setDefaultValues(properties);
        try(FileOutputStream fos = new FileOutputStream(myDocuments+"\\config.prop")) {
            properties.store(fos,null);
        } catch (IOException e) {
            System.out.println("Property file has not written");
        }
    }

    public static String load(String key){
        String result = "";
        try(FileInputStream  fis = new FileInputStream(new File(getPath()))) {
            Properties properties = new Properties();
            properties.load(fis);
            result = properties.getProperty(key);
        } catch (IOException e) {
            System.out.println("Property file has not loaded");
        }
        return result;
    }

    public static void update(String key,String value){
        Properties properties = new Properties();
        setOldValues(properties);
        properties.setProperty(key,value);
        try(FileOutputStream fos = new FileOutputStream(new File(getPath()))){
            properties.store(fos,null);
        } catch (IOException e) {
            System.out.println("Property file has not saved");
        }
    }

    public static boolean isPropFileExists(){
        return new File(getPath()).exists();
    }

    private static String getPath(){
        String path = new JFileChooser().getFileSystemView().getDefaultDirectory().toString();
        path+="\\AutoScreenshoter\\config.prop";
        return path;
    }

    private static void setDefaultValues(Properties p){
        p.setProperty(path,new JFileChooser().getFileSystemView().getDefaultDirectory().toString());
        p.setProperty(checked,"true");
        p.setProperty(prefixName,"Screenshot");
        p.setProperty(hours,"0");
        p.setProperty(minutes,"0");
        p.setProperty(count,"0");
    }

    private static void setOldValues(Properties p){
        try(FileInputStream fis = new FileInputStream(new File(getPath()))) {
            Properties old = new Properties();
            old.load(fis);
            p.setProperty(path,old.getProperty(path));
            p.setProperty(checked,old.getProperty(checked));
            p.setProperty(prefixName,old.getProperty(prefixName));
            p.setProperty(hours,old.getProperty(hours));
            p.setProperty(minutes,old.getProperty(minutes));
            p.setProperty(count,old.getProperty(count));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Property file has not loaded2");
        }
    }
}
