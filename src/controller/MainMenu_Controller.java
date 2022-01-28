package controller;

import model.Model;
import view.GameView;
import view.SettingView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class MainMenu_Controller extends Controller{
    public MainMenu_Controller(Container view) {
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

    @Override
    public void loadSetting() {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_P){play();}
        else if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_S){setting();}
        else if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_Q){exit();}
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public void play(){
        JFrame frame = (JFrame) view;
        new GameView().setVisible(true);
        frame.dispose();
    }

    public void setting(){
        JFrame frame = (JFrame) view;
        new SettingView().setVisible(true);
        frame.dispose();
    }

    public void exit(){
        System.exit(0);
    }
}
