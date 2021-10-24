package controller;

import java.awt.*;
import java.awt.event.KeyListener;

public abstract class Controller implements KeyListener {
    //attribute
    protected final Container view;

    //constructor
    public Controller(Container view) {
        this.view = view;
        view.addKeyListener(this);
    }

    //methode
    public void focus(){
        view.requestFocusInWindow();
    }
}
