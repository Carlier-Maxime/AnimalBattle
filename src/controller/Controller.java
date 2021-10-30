package controller;

import model.Model;
import view.View;

import java.awt.*;
import java.awt.event.KeyListener;

public abstract class Controller implements KeyListener {
    //attribute
    protected Container view;

    //constructor
    public Controller(Container view) {
        this.view = view;
        view.addKeyListener(this);
    }

    //methode
    public void focus(){
        view.requestFocusInWindow();
    }

    public View getView(){return (View) view;}
    public void setView(View view){this.view = (Container) view;}
    public abstract Model getModel();
    public abstract void setModel(Model model);
}
