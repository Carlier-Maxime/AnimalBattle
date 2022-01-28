package model;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Utils {
    public static final String PATH_DATA = "data";
    public static final String PATH_TEXTURE = PATH_DATA+"/texture";
    private static final String PATH_SETTING = PATH_DATA+"/settings.txt";
    public static GridBagConstraints initConstraints(){
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1;
        c.weighty = 1;
        return c;
    }

    public static JPanel hbox(){
        JPanel hbox = new JPanel();
        hbox.setLayout(new BoxLayout(hbox, BoxLayout.X_AXIS));
        return hbox;
    }

    public static String[] getSetting(String name){
        try {
            File file = new File(PATH_SETTING);
            Scanner scnr = new Scanner(file);
            while (scnr.hasNext()){
                String[] words = scnr.nextLine().split(" = ");
                if (words[0].equals(name)) return words[1].split(Pattern.quote(" | "));
            }
        } catch (Exception e){
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }

    public static int[] getIntSetting(String name){
        String[] settings = getSetting(name);
        if (settings==null) return null;
        int[] intSettings = new int[settings.length];
        for (int i=0; i<intSettings.length; i++){
            intSettings[i] = Integer.parseInt(settings[i]);
        }
        return intSettings;
    }
}
