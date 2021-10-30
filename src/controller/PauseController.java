package controller;

import model.Model;
import view.MainMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class PauseController extends Controller{
    //attribute

    //constructor
    public PauseController(Container view) {
        super(view);
    }

    @Override
    public Model getModel() {
        return null;
    }

    @Override
    public void setModel(Model model) {
        //empty
    }

    //methode
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE){
            resumeGame();
        } else if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_Q){
            mainMenu();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public void resumeGame(){
        Container parent = view.getParent();
        parent.remove(view);
        parent.revalidate();
        parent.repaint();
        parent.getParent().requestFocus();
    }

    public void mainMenu(){
        new MainMenu();
        Container parent = view.getParent();
        while (!JFrame.class.isAssignableFrom(parent.getClass())){
            parent = parent.getParent();
        }
        ((JFrame) parent).dispose();
    }
}
