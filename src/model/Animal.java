package model;

import java.util.ArrayList;
import java.util.Objects;

public abstract class Animal {
    //attribute
    private String name;
    private int health;
    private int energy;
    private ArrayList<IMovingStrategy> movingStrat;
    private ArrayList<ICombatStrategy> combatStrat;
    private int[] location;

    //constructor
    public Animal(String name, int health, int energy, ArrayList<IMovingStrategy> movingStrat, ArrayList<ICombatStrategy> combatStrat) {
        if (Objects.equals(name, "")){name = this.getClass().getSimpleName();}
        this.name = name;
        this.health = health;
        this.energy = energy;
        this.movingStrat = movingStrat;
        this.combatStrat = combatStrat;
        this.location = new int[]{0,0};
    }

    public Animal() {
        this("", 100, 100, null, null);
    }

    //methode
    public int[] getLocation(){
        return location;
    }

    public void setLocation(int[] location) {
        this.location = location;
    }
}
