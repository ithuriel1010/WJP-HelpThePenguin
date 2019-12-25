package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class pandaClick implements ActionListener {

    Window gra2;
    public pandaClick(Window game)
    {
        gra2 = game;
    }

    boolean panda_original = true;
    public void actionPerformed(ActionEvent e) {
        JButton b = (JButton) e.getSource();
        Window w = new Window();

        if (panda_original == true)
        {
            w.ButtonImage(b, "D:/Studia/Semestr V/Współczesne języki programowania/Projekt/Panda/VeryHappyPanda.png", 650,350, false);
            panda_original = false;
        } else if (panda_original == false)
        {
            w.ButtonImage(b, "D:/Studia/Semestr V/Współczesne języki programowania/Projekt/Panda/HappyPanda2.png", 650,350, false);
            panda_original = true;
        }

        gra2.setVisible(true);

    }


}
