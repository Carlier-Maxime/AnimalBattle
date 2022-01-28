package controller;

import model.Model;
import view.MainMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class SettingController extends Controller{
    public SettingController(Container view) {
        super(view);
    }

    @Override
    public Model getModel() {
        return null;
    }

    @Override
    public void setModel(Model model) {

    }

    @Override
    public void loadSetting() {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode()==KeyEvent.VK_ESCAPE){
            mainMenu();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public void mainMenu(){
        new MainMenu();
        ((JFrame) view).dispose();
    }
}
