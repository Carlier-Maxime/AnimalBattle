package view;

import controller.Controller;
import model.Model;
import model.Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyActionBox extends JPanel implements View {
    private final SettingView parent;
    private final String actionName;
    private final int[] keys;
    private final JButton[] buttonsKey;
    private int index;

    public KeyActionBox(String actionName, SettingView parent) {
        this.parent = parent;
        this.actionName = actionName;
        this.keys = Utils.getIntSetting(actionName);
        assert keys != null;
        buttonsKey = new  JButton[keys.length];
        index=-1;

        setSize(-1,100);
        setLayout(new GridBagLayout());
        GridBagConstraints c = Utils.initConstraints();
        c.gridy=0;
        add(new JLabel(actionName),c);
        for (int i=0; i<keys.length; i++){
            JButton button = new JButton(KeyEvent.getKeyText(keys[i]));
            int finalI = i;
            button.addActionListener((evt) -> {
                index=finalI;
                parent.setActionSelected(this);
                parent.getContentPane().requestFocus();
            });
            buttonsKey[i] = button;
            add(button,c);
        }
    }

    public void setKeySelected(KeyEvent e){
        if (index==-1) return;
        keys[index] = e.getKeyCode();
        buttonsKey[index].setText(KeyEvent.getKeyText(e.getKeyCode()));
        index = -1;
    }

    @Override
    public Model getModel() {
        return null;
    }

    @Override
    public Controller getController() {
        return null;
    }

    @Override
    public void setModel(Model model) {

    }

    @Override
    public void setController(Controller controller) {

    }

    public void apply(){
        Utils.setIntSetting(actionName,keys);
    }

    // ...
}
