package model;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;

public abstract class Animal {
    //attribute
    private String name;
    private int health;
    private int energy;
    private ArrayList<IMovingStrategy> movingStrat;
    private ArrayList<ICombatStrategy> combatStrat;
    private int[] location;
    private String pathTexture;

    //constructor
    public Animal(String name, int health, int energy, ArrayList<IMovingStrategy> movingStrat, ArrayList<ICombatStrategy> combatStrat) {
        if (Objects.equals(name, "")){name = this.getClass().getSimpleName();}
        this.name = name;
        this.health = health;
        this.energy = energy;
        this.movingStrat = movingStrat;
        this.combatStrat = combatStrat;
        this.location = new int[]{0,0};

        String nameFolder = getClass().getSimpleName().toLowerCase(Locale.ROOT);
        if (nameFolder.equals("character")){nameFolder = "dog";}
        pathTexture =  Utils.PATH_TEXTURE+"/animals/"+nameFolder;
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

    public BufferedImage getIcon(String direction){
        try {
            String imgLink = pathTexture+"/"+direction+".png";
            return ImageIO.read(new File(imgLink));
        } catch (Exception e){
            System.out.println(e.getMessage());
            System.exit(1);
        }
        return null;
    }

    public BufferedImage getIcon(){
        return getIcon("right");
    }
}
