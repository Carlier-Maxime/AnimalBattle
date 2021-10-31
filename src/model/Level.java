package model;

import controller.Controller;
import view.GamePanel;
import view.View;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Level implements Model{
    //attribute
    private ArrayList<ArrayList<Integer>> array;
    private ArrayList<Animal> animal;
    private Character character;
    private GamePanel view;
    private Controller controller;

    //constructor
    public Level(String levelName) {
        animal = new ArrayList<>();
        character = new Character();
        array = new ArrayList<>();
        try {
            Scanner scnr = new Scanner(new File("src/data/"+levelName));
            while (scnr.hasNext()){
                array.add(new ArrayList<>());
                String line = scnr.nextLine();
                for (String s: line.split(" ")) {
                    array.get(array.size()-1).add(Integer.parseInt(s));
                }
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }

    //methode
    public ArrayList<ArrayList<Integer>> getArray(){
        return array;
    }

    @Override
    public View getView() {
        return view;
    }

    @Override
    public Controller getController() {
        return controller;
    }

    @Override
    public void setView(View view) {
        this.view = (GamePanel) view;
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void moveCharacter(int offsetX, int offsetY){
        String direction;
        if (offsetX == -1){direction = "left";}
        else if (offsetX == 1){direction = "right";}
        else if (offsetY == -1){direction = "up";}
        else {direction = "down";}
        int[] oldPos = character.getLocation();
        int[] newPos = new int[]{oldPos[0]+offsetX, oldPos[1]+offsetY};
        if (newPos[0] < 0 || newPos[0] > array.get(0).size()-1 || newPos[1] < 0 || newPos[1] > array.size()-1){
            return;
        } //if (array.get(newPos[1]).get(newPos[0]) == ) //A completer
        character.setLocation(newPos);
        view.updateCharacter(character, oldPos, direction);
    }

    public Character getCharacter() {
        return character;
    }
}
