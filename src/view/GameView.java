package view;

import controller.Controller;
import controller.GameController;
import model.Animal;
import model.Character;
import model.Level;
import model.Model;

import javax.swing.*;
import java.awt.*;

public class GameView extends JFrame implements View{
    //attribute
    private Level model;
    private Controller controller;

    //constructor
    public GameView(Level model){
        //initialisation (title, size, closeOperation, background, controller, model)
        super("Animal Battle");
        this.model = model; // model
        this.model.setView(this);
        this.controller = new GameController(getContentPane(), model);
        this.model.setController(this.controller);
        setExtendedState(MAXIMIZED_BOTH);
        setUndecorated(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //preparation du GamePanel
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx=1;
        constraints.weighty=1;
        JPanel overlay = new JPanel();
        overlay.setLayout(new OverlayLayout(overlay));
        add(overlay, constraints);
        JPanel GamePanel = new JPanel();
        GamePanel.setLayout(new GridBagLayout());
        overlay.add(GamePanel, constraints);
        GamePanel.setBounds(0,0,getWidth(),getHeight());

        //affichage de la grille
        for (int y=0; y<model.getArray().size(); y++){
            for (int x=0; x<model.getArray().get(y).size(); x++){
                constraints.gridy = y;
                constraints.gridx = x;
                Integer caze = model.getArray().get(y).get(x);
                JPanel pan1 = new JPanel();
                pan1.setLayout(new GridBagLayout());
                switch (caze) {
                    case 0 -> pan1.setBackground(Color.green);
                    case 1 -> pan1.setBackground(new Color(7, 68, 1));
                    default -> pan1.setBackground(Color.white);
                }
                GamePanel.add(pan1, constraints);
            }
        }
        updateCharacter(model.getCharacter(), null);

        //set visibile and focus
        setVisible(true);
        controller.focus();
    }

    public GameView(){
        this(new Level("level_0_0.txt"));
    }

    //methode

    @Override
    public void setBounds(int x, int y, int width, int height) {
        super.setBounds(x, y, width, height);
        for (int i=0; i<getComponentCount(); i++){
            getComponent(i).setBounds(0,0,width,height);
        }
    }

    @Override
    public Model getModel() {
        return model;
    }

    @Override
    public Controller getController() {
        return controller;
    }

    @Override
    public void setModel(Model model) {
        this.model = (Level) model;
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void updateAnimal(Animal animal, int[] oldPos){
        if (oldPos != null && oldPos[0] >= 0 && oldPos[1] >= 0){
            getCase(oldPos).remove(0);
        }
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1;
        c.weighty = 1;
        JPanel pan = new JPanel();
        pan.setBackground(Color.RED);
        getCase(animal.getLocation()).add(pan, c);

        revalidate();
        repaint();
    }

    public void updateCharacter(Character character, int[] oldPos){
        updateAnimal(character, oldPos);
    }

    public JPanel getGamePanel(){
        return ((JPanel) ((JPanel) getContentPane().getComponent(0)).getComponent(0));
    }

    public JPanel getCase(int[] position){
        return (JPanel) getGamePanel().getComponent(position[1]*model.getArray().get(0).size()+position[0]);
    }
}
