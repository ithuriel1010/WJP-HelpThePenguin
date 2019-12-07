package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;

import static javax.print.attribute.standard.MediaSize.JIS.B1;



public class Main {

    public static int hungry = 500;
    public static JTextArea hungryPoints;

    public static void main(String[] args) {

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();
        System.out.println(width);
        System.out.println(height);



        Main m = new Main();

        Window game = new Window("Help the Penguin",width, height, width/2, height/2 );

        try
        {
            game.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("D:/Studia/Semestr V/Współczesne języki programowania/Projekt/Background/Snowy/01/snowy01_preview-01.png")))));
        }
        catch(Exception e)
        {
            System.out.println("Błąd pliku backgroung");
        }


        JPanel mainPanel = new JPanel();
        mainPanel.setVisible(true);

        JButton food = new JButton();
        JButton sleep = new JButton();
        JButton friend = new JButton();
        JButton penguin = new JButton();

        game.ButtonImage(food, "D:/Studia/Semestr V/Współczesne języki programowania/Projekt/Foods/PNG/Eggs.png",1300,0,true);
        game.ButtonImage(sleep,"D:/Studia/Semestr V/Współczesne języki programowania/Projekt/SleepCloud.png",1300,220,true);
        game.ButtonImage(friend,"D:/Studia/Semestr V/Współczesne języki programowania/Projekt/Panda/Panda.png",1300,440,true);
        game.ButtonImage(penguin,"D:/Studia/Semestr V/Współczesne języki programowania/Projekt/Penguin/HappyPenguin.png",500,275,false);

        penguin.addActionListener(new penguinClick(game));
        food.addActionListener(new foodClick(game));
        sleep.addActionListener(new sleepClick(game, penguin));
        //friend.addActionListener(new friendClick());

        hungryPoints = new JTextArea();
        hungryPoints.setText("Health: "+ String.valueOf(hungry));
        hungryPoints.setBounds(550,100,500,50);
        hungryPoints.setOpaque(false);
        hungryPoints.setVisible(true);

        Font font = hungryPoints.getFont();
        float size = font.getSize() + 10.0f;
        hungryPoints.setFont( font.deriveFont(size) );

        game.add(food);
        game.add(sleep);
        game.add(friend);
        game.add(penguin);
        game.add(hungryPoints);
        game.setVisible(true);
    }

}

