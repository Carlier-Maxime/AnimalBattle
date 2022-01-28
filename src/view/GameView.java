package view;

import controller.Controller;
import controller.GameController;
import model.Level;
import model.Model;
import model.Utils;

import javax.swing.*;
import java.awt.*;

public class GameView extends JFrame implements View{
    //attribute
    private GameController controller;

    //constructor
    public GameView(){
        //initialisation (title, size, closeOperation, background, controller, model)
        super("Animal Battle");
        this.controller = new GameController(this.getContentPane());
        setExtendedState(MAXIMIZED_BOTH);
        setUndecorated(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //Overlay
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = Utils.initConstraints();
        constraints.insets = new Insets(-5,-6,-5,-6);
        JPanel overlay = new JPanel();
        overlay.setLayout(new OverlayLayout(overlay));
        add(overlay, constraints);

        GamePanel gamePanel = new GamePanel();
        //Preparation zone GamePanel
        JPanel hbox = new JPanel();
        hbox.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(-1,-1,-1,-1);
        Dimension dim = getToolkit().getScreenSize();
        c.weightx = ((dim.width-dim.height)/2.0)/dim.height;
        c.weighty = 1;
        c.gridx = 0;
        JPanel leftPan = new JPanel();
        leftPan.setBackground(Color.BLACK);
        hbox.add(leftPan, c);
        c.gridx = 2;
        hbox.add(new InfoCharacter(((Level) gamePanel.getModel()).getCharacter()), c);
        c.gridx = 1;
        c.weightx = 1;
        overlay.add(hbox, constraints);

        //add GamePanel
        hbox.add(gamePanel, c);
        this.controller.setControllerChild(gamePanel.getController());

        //set visibile and focus
        setVisible(true);
        controller.focus();
    }

    //methode

    @Override
    public void setBounds(int x, int y, int width, int height) {
        super.setBounds(x, y, width, height);
        for (int i=0; i<getComponentCount(); i++){
            getComponent(i).setBounds(0,0,width,height);
        }
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
        // empty
    }

    @Override
    public void setController(Controller controller) {
        this.controller = (GameController) controller;
    }

    public JPanel getGamePanel(){
        return ((JPanel) ((JPanel) getContentPane().getComponent(0)).getComponent(0));
    }
}
