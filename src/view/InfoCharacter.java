package view;


import model.Character;
import model.Utils;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class InfoCharacter extends JPanel{
    private Character character;

    public InfoCharacter(Character character) {
        super();
        try {
            this.character = character;
            setBackground(Color.DARK_GRAY);
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            addHbox(character.getIcon(), character.getName());
            addHbox(ImageIO.read(new File(Utils.PATH_TEXTURE+"/gui/heart.png")),Integer.toString(character.getHealth()));
            addHbox(ImageIO.read(new File(Utils.PATH_TEXTURE+"/gui/energy.png")),Integer.toString(character.getEnergy()));
        } catch (Exception e){
            e.printStackTrace();
            System.exit(1);
        }
    }

    private void addHbox(BufferedImage icon, String info){
        JPanel hbox = Utils.hbox();
        hbox.setOpaque(false);
        JLabel icone = new JLabel();
        icone.setIcon(new ImageIcon(icon));
        JLabel name = new JLabel(info);
        name.setForeground(Color.WHITE);
        hbox.add(icone);
        hbox.add(name);
        add(hbox);
    }
}
