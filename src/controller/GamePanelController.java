package controller;

import model.Level;
import model.Model;
import model.Utils;

import java.awt.*;
import java.awt.event.KeyEvent;

public class GamePanelController extends Controller{
    //static
    private static int[] MOVE_LEFT;
    private static int[] MOVE_UP;
    private static int[] MOVE_RIGHT;
    private static int[] MOVE_DOWN;

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

    @Override
    public void loadSetting() {
        MOVE_LEFT = Utils.getIntSetting("MOVE_LEFT");
        MOVE_UP = Utils.getIntSetting("MOVE_UP");
        MOVE_RIGHT = Utils.getIntSetting("MOVE_RIGHT");
        MOVE_DOWN = Utils.getIntSetting("MOVE_DOWN");
    }

    //methode
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (isGoodKey(key,MOVE_LEFT)){
            model.moveCharacter(-1,0);
        } if (isGoodKey(key,MOVE_UP)){
            model.moveCharacter(0,-1);
        } if (isGoodKey(key,MOVE_RIGHT)){
            model.moveCharacter(1,0);
        } if (isGoodKey(key,MOVE_DOWN)){
            model.moveCharacter(0,1);
        } if (e.getKeyCode() == KeyEvent.VK_A){
            model.addAnimal();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
