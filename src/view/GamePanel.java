package view;

import controller.Controller;
import controller.GamePanelController;
import model.Animal;
import model.Character;
import model.Level;
import model.Model;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements View{
    private Level level;
    private GamePanelController controller;

    public GamePanel(Level level) {
        this.level = level;
        this.level.setView(this);
        this.controller = new GamePanelController(this, level);
        setLayout(new GridBagLayout());
        //affichage de la grille
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 1;
        constraints.weighty = 1;
        for (int y=0; y<level.getArray().size(); y++){
            for (int x=0; x<level.getArray().get(y).size(); x++){
                constraints.gridy = y;
                constraints.gridx = x;
                Integer caze = level.getArray().get(y).get(x);
                String imgLink = "src/data/texture/";
                switch (caze) {
                    case 0 -> imgLink += "plaine.jpg";
                    case 1 -> imgLink += "foret.jpg";
                    default -> imgLink += "error.jpg";
                }
                JPanel pan = new Case(imgLink);
                pan.setLayout(new GridBagLayout());
                add(pan, constraints);
            }
        }
        updateCharacter(level.getCharacter(), null, "right");
    }

    public GamePanel(){
        this(new Level("level_0_0.txt"));
    }

    public void updateAnimal(Animal animal, int[] oldPos, String direction){
        if (oldPos != null && oldPos[0] >= 0 && oldPos[1] >= 0){
            getCase(oldPos).remove(0);
        }
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1;
        c.weighty = 1;
        JPanel pan = new Case("src/data/texture/dog/dog_"+direction+".png");
        pan.setOpaque(false);
        getCase(animal.getLocation()).add(pan, c);

        revalidate();
        repaint();
    }

    public void updateCharacter(Character character, int[] oldPos, String direction){
        updateAnimal(character, oldPos, direction);
    }

    public JPanel getCase(int[] position){
        return (JPanel) this.getComponent(position[1]*level.getArray().get(0).size()+position[0]);
    }

    @Override
    public Model getModel() {
        return level;
    }

    @Override
    public Controller getController() {
        return controller;
    }

    @Override
    public void setModel(Model model) {
        level = (Level) model;
    }

    @Override
    public void setController(Controller controller) {
        this.controller = (GamePanelController) controller;
    }
}
