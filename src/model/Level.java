package model;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Level{
    //attribute
    private ArrayList<ArrayList<int[]>> array;

    //constructor
    public Level(String levelName) {
        array = new ArrayList<>();
        try {
            Scanner scnr = new Scanner(new File("src/data/"+levelName));
            while (scnr.hasNext()){
                array.add(new ArrayList<>());
                String line = scnr.nextLine();
                for (String s: line.split(" ")) {
                    String[] caze = s.split(",");
                    array.get(array.size()-1).add(new int[]{Integer.parseInt(caze[0]), Integer.parseInt(caze[1])});
                }
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }

    //methode
    public ArrayList<ArrayList<int[]>> getArray(){
        return array;
    }
}
