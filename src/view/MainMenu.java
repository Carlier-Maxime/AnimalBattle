package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame {
    //attribute

    //constructor
    public MainMenu(){
        //initialisation (title, size, closeOperation, background)
        super("Animal Battle");
        setExtendedState(MAXIMIZED_BOTH);
        setUndecorated(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.BLACK);


        //creation du menu - create button
        JButton play = new Button("Play");
        play.addActionListener(e -> JOptionPane.showMessageDialog(getContentPane(), "Non Disponible !"));
        JButton setting = new Button("Settings");
        setting.addActionListener(e -> JOptionPane.showMessageDialog(getContentPane(), "Non Disponible !"));
        JButton quit = new Button("Quit Game");
        quit.addActionListener(e -> System.exit(0));
        //creation du menu - layout
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 1;
        constraints.weighty = 1.0;
        constraints.gridx = 0;
        JPanel pan = new JPanel();
        pan.setOpaque(false);
        add(pan, constraints);
        constraints.gridx = 2;
        pan = new JPanel();
        pan.setOpaque(false);
        add(pan, constraints);
        constraints.gridx = 1;
        constraints.weightx = 0.4;
        constraints.insets = new Insets(50,0,50,0);
        //creation du menu - add button + title
        JLabel title = new JLabel("Animal Battle", SwingConstants.CENTER);
        title.setFont(new Font("Serif", Font.BOLD, 72));
        title.setForeground(Color.WHITE);
        add(title, constraints);
        add(play, constraints);
        add(setting, constraints);
        constraints.insets = new Insets(50,0,250,0);
        add(quit, constraints);
        //creation du menu - add information Version
        constraints.gridx = 0;
        constraints.weightx = 1;
        constraints.gridy = 3;
        //constraints.weighty = 0;
        constraints.anchor = GridBagConstraints.SOUTH;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(0,5,5,0);
        JLabel infoVersion = new JLabel("Version : 0.0.0");
        infoVersion.setForeground(Color.WHITE);
        add(infoVersion, constraints);

        //finition (Show windows)
        setVisible(true);
    }

    //methode
}
