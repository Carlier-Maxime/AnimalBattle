package model;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
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

    public static void setSetting(String name, String[] values){
        try {
            ArrayList<String> lines = new ArrayList<>();
            File file = new File(PATH_SETTING);
            Scanner scnr = new Scanner(file);
            while (scnr.hasNext()){
                String line = scnr.nextLine();
                if (line.split(" = ")[0].equals(name)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(name).append(" = ");
                    for (int i=0; i< values.length; i++){
                        sb.append(values[i]);
                        if (i < values.length-1) sb.append(" | ");
                    }
                    lines.add(sb.toString());
                } else lines.add(line);
            }
            scnr.close();
            PrintWriter flux = new PrintWriter(file);
            for (String line : lines){
                flux.write(line);
                flux.write('\n');
            }
            flux.flush();
            flux.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void setIntSetting(String name, int[] values){
        String[] valuesStr = new String[values.length];
        for (int i=0; i< values.length; i++){
            valuesStr[i] = Integer.toString(values[i]);
        }
        setSetting(name,valuesStr);
    }
}
