package model;

import javax.swing.*;
import java.awt.*;

public class Utils {
    public static final String PATH_TEXTURE = "src/data/texture";
    public static GridBagConstraints initConstraints(){
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1;
        c.weighty = 1;
        return c;
    }

    public static JPanel hbox(){
        JPanel hbox = new JPanel();
        hbox.setLayout(new BoxLayout(hbox, BoxLayout.X_AXIS));
        return hbox;
    }
}
