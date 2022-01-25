package view;

import controller.Controller;
import controller.GamePanelController;
import model.*;
import model.Character;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements View{
    private Level level;
    private GamePanelController controller;

    public GamePanel(Level level) {
        this.level = level;
        this.level.setView(this);
        this.controller = new GamePanelController(this, level);
        setBackground(Color.BLACK);
        setLayout(new GridBagLayout());
        //affichage de la grille
        GridBagConstraints constraints = Utils.initConstraints();
        for (int y=0; y<level.getArray().size(); y++){
            for (int x=0; x<level.getArray().get(y).size(); x++){
                constraints.gridy = y;
                constraints.gridx = x;
                Integer caze = level.getArray().get(y).get(x);
                String imgLink = Utils.PATH_TEXTURE;
                switch (caze) {
                    case 0 : imgLink += "/plaine.jpg"; break;
                    case 1 : imgLink += "/foret.jpg"; break;
                    default : imgLink += "/error.jpg"; break;
                }
                JPanel pan = new Case(imgLink);
                pan.setLayout(new GridBagLayout());
                add(pan, constraints);
                JPanel pan2 = new JPanel();
                pan2.setOpaque(false);
                GridBagConstraints c = Utils.initConstraints();
                pan.add(pan2, c);
            }
        }
        updateCharacter(level.getCharacter(), null, "right");
    }

    public GamePanel(){
        this(new Level("level_0_0.txt"));
    }

    public void updateAnimal(Animal animal, int[] oldPos, String direction){
        GridBagConstraints c = Utils.initConstraints();
        if (oldPos != null && oldPos[0] >= 0 && oldPos[1] >= 0){
            getCase(oldPos).remove(0);
            JPanel pan = new JPanel();
            pan.setOpaque(false);
            getCase(oldPos).add(pan, c);
        }
        JPanel pan = new Case(animal.getImg(direction));
        pan.setOpaque(false);
        getCase(animal.getLocation()).remove(0);
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
