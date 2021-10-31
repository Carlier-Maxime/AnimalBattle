package controller;

import model.Model;
import view.PauseView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class GameController extends Controller{
    private Controller controllerChild;

    public GameController(Container view) {
        super(view);
        controllerChild = null;
    }

    @Override
    public Model getModel() {
        return null;
    }

    @Override
    public void setModel(Model model) {

    }

    @Override
    public void keyTyped(KeyEvent e) {
        controllerChild.keyTyped(e);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            pause();
        }
        controllerChild.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        controllerChild.keyReleased(e);
    }

    public void setControllerChild(Controller controller){
        this.controllerChild = controller;
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
