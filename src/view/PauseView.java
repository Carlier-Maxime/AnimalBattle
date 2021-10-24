package view;

import controller.Controller;
import controller.GameController;
import controller.PauseController;

import javax.swing.*;
import java.awt.*;

public class PauseView extends JPanel {
    //attribute
    private final PauseController controller;

    //constructor
    public PauseView() {
        super();
        this.controller = new PauseController(this);
        setBackground(Color.BLACK);

        //preparation du layout et de ces contraintes
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.gridx = 0;

        //Preparation pour centrer les button
        JPanel pan = new JPanel();
        pan.setOpaque(false);
        add(pan, constraints);
        constraints.gridx = 2;
        pan = new JPanel();
        pan.setOpaque(false);
        add(pan, constraints);
        constraints.gridx = 1;

        //create button
        JButton resumeGame = new Button("Resume Game");
        resumeGame.addActionListener(e->controller.resumeGame());
        JButton mainMenu = new Button("Main Menu");
        mainMenu.addActionListener(e->controller.mainMenu());

        //add button
        constraints.insets = new Insets(50,0,50,0);
        constraints.weightx = 0.4;
        add(resumeGame, constraints);
        add(mainMenu, constraints);

        //set visibile and focus
        setVisible(true);
        controller.focus();
    }
}
