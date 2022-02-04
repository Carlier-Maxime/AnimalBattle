package view;

import controller.Controller;
import controller.SettingController;
import model.Model;
import model.Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class SettingView extends JFrame implements View {
    private Controller controller;
    private ArrayList<KeyActionBox> keyActionBoxes;
    private KeyActionBox actionSelected;

    public SettingView(){
        super("Animal Battle");
        actionSelected = null;
        controller = new SettingController(this);
        getContentPane().addKeyListener(controller);
        setExtendedState(MAXIMIZED_BOTH);
        setUndecorated(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new GridBagLayout());
        GridBagConstraints c = Utils.initConstraints();
        c.gridx=0;
        keyActionBoxes = new ArrayList<>();
        keyActionBoxes.add(new KeyActionBox("MOVE_LEFT",this));
        keyActionBoxes.add(new KeyActionBox("MOVE_UP",this));
        keyActionBoxes.add(new KeyActionBox("MOVE_RIGHT",this));
        keyActionBoxes.add(new KeyActionBox("MOVE_DOWN",this));
        for (KeyActionBox pan : keyActionBoxes){
            add(pan,c);
        }

        JPanel hbox = Utils.hbox();
        JButton back = new JButton("Back");
        back.addActionListener((evt) -> ((SettingController) controller).mainMenu());
        hbox.add(back);
        JButton apply = new JButton("Apply");
        apply.addActionListener((evt) -> apply());
        hbox.add(apply);
        add(hbox,c);

        setVisible(true);
        getContentPane().requestFocus();
    }

    public boolean editActionKeySelected(KeyEvent e){
        if (actionSelected==null) return false;
        actionSelected.setKeySelected(e);
        actionSelected = null;
        return true;
    }

    @Override
    public Model getModel() {
        return null;
    }

    @Override
    public Controller getController() {
        return controller;
    }

    @Override
    public void setModel(Model model) {

    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void setActionSelected(KeyActionBox keyActionBox){
        actionSelected = keyActionBox;
    }

    private void apply(){
        for (KeyActionBox actionBox : keyActionBoxes) {
            actionBox.apply();
        }
    }
}
