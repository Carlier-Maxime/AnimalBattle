package controller;

import view.PauseView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameController extends Controller{
    //attribute

    //constructor
    public GameController(Container view) {
        super(view);
    }

    //methode
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE){
            pause();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public void pause(){
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 1;
        constraints.weighty = 1;
        PauseView pauseView = new PauseView();
        JPanel overlay = (JPanel) view.getComponent(0);
        overlay.add(pauseView, constraints);
        pauseView.setBounds(0,0,view.getWidth(),view.getHeight());
        view.revalidate();
        pauseView.requestFocusInWindow();
    }
}
