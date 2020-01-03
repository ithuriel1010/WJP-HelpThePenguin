package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PandaClick implements ActionListener {

    Window gameWindow;
    public PandaClick(Window game)
    {
        gameWindow = game;
    }

    boolean panda_original = true;
    public void actionPerformed(ActionEvent e) {
        JButton b = (JButton) e.getSource();
        Window w = new Window();

        if (panda_original == true)
        {
            w.ButtonImage(b, "./VeryHappyPanda.png", 650,350, false);
            panda_original = false;
        } else if (panda_original == false)
        {
            w.ButtonImage(b, "./HappyPanda2.png", 650,350, false);
            panda_original = true;
        }

        gameWindow.setVisible(true);
    }
}
