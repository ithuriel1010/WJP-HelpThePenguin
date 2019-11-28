package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class penguinClick implements ActionListener {
    boolean penguin_original = true;
    public void actionPerformed(ActionEvent e) {
       JButton b = (JButton) e.getSource();


        Window w = new Window("X",25,25,22,65);

        if(penguin_original==true)
        {
            w.ButtonImage(b,"D:/Studia/Semestr V/Współczesne języki programowania/Projekt/Penguin/CutePenguin.png",500,275,false);
            penguin_original=false;
        }
        else if (penguin_original==false){
            w.ButtonImage(b, "D:/Studia/Semestr V/Współczesne języki programowania/Projekt/Penguin/HappyPenguin.png", 500, 275, false);
            penguin_original = true;
        }
    }
}
