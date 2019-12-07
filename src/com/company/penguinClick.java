package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class penguinClick implements ActionListener {

    Window gra2;
    JTextArea hugInfo = new JTextArea();

    public penguinClick(Window game)
    {
        gra2 = game;
        hugInfo.setEditable(false);
        hugInfo.setOpaque(false);
        hugInfo.setText("Huggsy bardzo lubi przytulanie!");
        hugInfo.setBounds(600,180,500,50);
        Font font = hugInfo.getFont();
        float size = font.getSize() + 10.0f;
        hugInfo.setFont( font.deriveFont(size) );
    }

    boolean penguin_original = true;
    public void actionPerformed(ActionEvent e) {
       JButton b = (JButton) e.getSource();
        Window w = new Window("X",25,25,22,65);

        if(penguin_original==true)
        {
            hugInfo.setVisible(true);
            w.ButtonImage(b,"D:/Studia/Semestr V/Współczesne języki programowania/Projekt/Penguin/CutePenguin.png",500,275,false);
            penguin_original=false;
        }
        else if (penguin_original==false){
            hugInfo.setVisible(false);
            w.ButtonImage(b, "D:/Studia/Semestr V/Współczesne języki programowania/Projekt/Penguin/HappyPenguin.png", 500, 275, false);
            penguin_original = true;
        }
        //hugInfo.setVisible(true);
        gra2.add(hugInfo);
        gra2.setVisible(true);
    }
}
