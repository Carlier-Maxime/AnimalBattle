package view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Case extends JPanel {
    private BufferedImage bufImg;

    public Case(String imgLink) {
        try {
            this.bufImg = ImageIO.read(new File(imgLink));
        } catch (Exception e){
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image img = bufImg.getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH);
        g.drawImage(img, 0, 0, this);
    }
}
