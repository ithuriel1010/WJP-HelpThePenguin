package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class friendClick implements ActionListener {

    public Window g;
    public JButton penguin;
    public JButton panda = new JButton();


    public friendClick(Window gameWindow, JButton penguin) {
        g = gameWindow;
        this.penguin=penguin;
    }

    public void actionPerformed(ActionEvent e)
    {
        try
        {
            g.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("D:/Studia/Semestr V/Współczesne języki programowania/Projekt/Background/Forest/Cartoon_Forest_BG_02/Cartoon_Forest_BG_02.png")))));
        }
        catch(Exception m)
        {
            System.out.println("Błąd pliku backgroung");
        }

        g.ButtonImage(penguin,"D:/Studia/Semestr V/Współczesne języki programowania/Projekt/Penguin/veryHappy.png",350,350,false);
        g.ButtonImage(panda,"D:/Studia/Semestr V/Współczesne języki programowania/Projekt/Panda/HappyPanda.png",650,350,false);


        Main.happy+=500;
        Main.happyPoints.setText("Mood: "+ String.valueOf(Main.happy));



        g.add(penguin);
        g.add(panda);
        g.add(Main.happyPoints);
        g.add(Main.hungryPoints);
        g.setVisible(true);
    }
}
