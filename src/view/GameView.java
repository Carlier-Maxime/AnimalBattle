package view;

import javax.swing.*;
import java.awt.*;

public class GameView extends JFrame {
    //attribute

    //constructor
    public GameView(){
        //initialisation (title, size, closeOperation, background)
        super("Animal Battle");
        setExtendedState(MAXIMIZED_BOTH);
        setUndecorated(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //affichage de la grille
        setLayout(new GridBagLayout());
    }
}
