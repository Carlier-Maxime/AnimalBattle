package view;

import controller.Controller;
import controller.SettingController;
import model.Model;
import model.Utils;

import javax.swing.*;
import java.awt.*;

public class SettingView extends JFrame implements View {
    Controller controller;

    public SettingView(){
        super("Animal Battle");
        controller = new SettingController(this);
        setExtendedState(MAXIMIZED_BOTH);
        setUndecorated(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new GridBagLayout());
        GridBagConstraints c = Utils.initConstraints();

        requestFocus();
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
}
