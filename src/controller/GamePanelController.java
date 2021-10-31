package controller;

import model.Level;
import model.Model;
import java.awt.*;
import java.awt.event.KeyEvent;

public class GamePanelController extends Controller{
    //attribute
    private Level model;

    //constructor
    public GamePanelController(Container view, Level model) {
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
        if (e.getKeyCode() == KeyEvent.VK_LEFT){
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
}
