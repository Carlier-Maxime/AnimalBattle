package controller;

import model.Level;
import model.Model;
import view.PauseView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class GameController extends Controller{
    //attribute
    private Level model;

    //constructor
    public GameController(Container view, Level model) {
        super(view);
        this.model = model;
    }

    @Override
    public Model getModel() {
        return model;
    }

    @Override
    public void setModel(Model model) {
        this.model = (Level) model;
    }

    //methode
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE){
            pause();
        } if (e.getKeyCode() == KeyEvent.VK_LEFT){
            model.moveCharacter(-1,0);
        } if (e.getKeyCode() == KeyEvent.VK_UP){
            model.moveCharacter(0,-1);
        } if (e.getKeyCode() == KeyEvent.VK_RIGHT){
            model.moveCharacter(1,0);
        } if (e.getKeyCode() == KeyEvent.VK_DOWN){
            model.moveCharacter(0,1);
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
