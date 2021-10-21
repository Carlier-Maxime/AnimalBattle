package view;

import javax.swing.*;
import java.awt.*;

public class Button extends JButton {
    //attribute
    private final Color hoverColor = Color.GRAY;
    private final Color pressedColor = Color.LIGHT_GRAY;
    private final Color normalColor = Color.DARK_GRAY;

    //constructor
    public Button(String text) {
        super(text);
        setFont(new Font("Serif", Font.BOLD, 32));
        setForeground(Color.WHITE);
        setBackground(normalColor);
        setFocusPainted(false);
        setBorderPainted(false);
        addChangeListener(e -> {
            if (getModel().isPressed()){
                setBackground(pressedColor); // not work
            } else if (getModel().isRollover()){
                setBackground(hoverColor);
            } else {
                setBackground(normalColor);
            }
        });
    }
}
