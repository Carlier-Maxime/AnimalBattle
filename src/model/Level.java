package model;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Level {
    //attribute
    private ArrayList<ArrayList<int[]>> array;

    //constructor
    public Level(String levelName) {
        array = new ArrayList<>();
        try {
            Scanner scnr = new Scanner(new File(levelName));
            while (scnr.hasNext()){
                array.add(new ArrayList<>());
                String line = scnr.nextLine();
                for (String s: line.split(" ")) {
                    String[] caze = s.split(",");
                    array.get(array.size()-1).add(new int[]{Integer.getInteger(caze[0]), Integer.getInteger(caze[1])});
                }
            }
        } catch (Exception e){
            System.out.println(e.getMessage()+"\n"+e.getLocalizedMessage());
            System.exit(1);
        }
    }
}
