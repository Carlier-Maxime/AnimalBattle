package view;

import controller.Controller;
import controller.GameController;
import model.Level;

import javax.swing.*;
import java.awt.*;
import java.security.KeyPair;
import java.util.ArrayList;

public class GameView extends JFrame {
    //attribute
    private Level level;
    private final Controller controller;

    //constructor
    public GameView(Level level){
        //initialisation (title, size, closeOperation, background, controller, model)
        super("Animal Battle");
        this.level = level; // model
        this.controller = new GameController(getContentPane());
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
        for (int y=0; y<level.getArray().size(); y++){
            for (int x=0; x<level.getArray().get(y).size(); x++){
                constraints.gridy = y;
                constraints.gridx = x;
                int[] caze = level.getArray().get(y).get(x);
                JPanel pan1 = new JPanel();
                pan1.setLayout(new GridBagLayout());
                switch (caze[0]) {
                    case 0 -> pan1.setBackground(Color.green);
                    case 1 -> pan1.setBackground(new Color(7, 68, 1));
                    default -> pan1.setBackground(Color.white);
                }
                JPanel pan2 = new JPanel();
                boolean addPan2 = true;
                switch (caze[1]) {
                    case 0 -> addPan2 = false;
                    case 1 -> pan2.setBackground(Color.red);
                    default -> pan2.setBackground(Color.black);
                }
                GridBagConstraints c = new GridBagConstraints();
                c.fill= GridBagConstraints.BOTH;
                c.weightx=1;
                c.weighty=1;
                if (addPan2){pan1.add(pan2, c);}
                GamePanel.add(pan1, constraints);
            }

            //set visibile and focus
            setVisible(true);
            controller.focus();
        }
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
}
