package model;

import controller.Controller;
import view.GamePanel;
import view.View;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Level implements Model{
    //attribute
    private ArrayList<ArrayList<Integer>> array;
    private ArrayList<Animal> animal;
    private Character character;
    private GamePanel view;
    private Controller controller;
    private Random rng;

    //constructor
    public Level(String levelName) {
        animal = new ArrayList<>();
        character = new Character();
        array = new ArrayList<>();
        rng = new Random();
        try {
            Scanner scnr = new Scanner(new File(Utils.PATH_DATA+"/"+levelName));
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
            view.updateCharacter(character, oldPos, direction);
        } else if (isAnimalIn(newPos)){
            view.updateCharacter(character, oldPos, direction);
        }
        else {
            character.setLocation(newPos);
            view.updateCharacter(character, oldPos, direction);
        }
    }

    public Character getCharacter() {
        return character;
    }

    public void addAnimal(){
        ArrayList<int[]> validPos = new ArrayList<>();
        for (int x=0; x<array.get(0).size(); x++){
            for (int y=0; y<array.size(); y++){
                validPos.add(new int[]{x,y});
            }
        }
        for (Animal a : animal){
            int[] locA = a.getLocation();
            validPos.removeIf(pos -> locA[0] == pos[0] && locA[1] == pos[1]);
        }
        validPos.removeIf(pos -> character.getLocation()[0] == pos[0] && character.getLocation()[1] == pos[1]);
        if (validPos.size()<=0){return;}
        int[] pos = validPos.get(getRandomInt(0, validPos.size()-1));
        Animal a = new Dog();
        a.setLocation(pos);
        animal.add(a);
        view.updateAnimal(a, null, "up");
    }

    public boolean isAnimalIn(int[] pos){
        for (Animal a : animal){
            if (a.getLocation()[0] == pos[0] && a.getLocation()[1] == pos[1]){
                return true;
            }
        }
        return false;
    }

    private int getRandomInt(int min, int max){
        return rng.nextInt((max - min) + 1) + min;
    }
}
