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
    public static int happy = 500;
    public static JTextArea hungryPoints;
    public static JTextArea happyPoints;
    public static boolean isWithFriend=false;
    public static JButton food = new JButton();
    public static JButton sleep = new JButton();
    public static JButton friend = new JButton();
    public static JButton penguin = new JButton();


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



        game.ButtonImage(food, "D:/Studia/Semestr V/Współczesne języki programowania/Projekt/Foods/PNG/Eggs.png",1300,0,true);
        game.ButtonImage(sleep,"D:/Studia/Semestr V/Współczesne języki programowania/Projekt/SleepCloud.png",1300,220,true);
        game.ButtonImage(friend,"D:/Studia/Semestr V/Współczesne języki programowania/Projekt/Panda/Panda2.png",1300,440,true);
        game.ButtonImage(penguin,"D:/Studia/Semestr V/Współczesne języki programowania/Projekt/Penguin/Pengiun2.png",480,285,false);

        penguin.addActionListener(new penguinClick(game));
        food.addActionListener(new foodClick(game, penguin));
        sleep.addActionListener(new sleepClick(game, penguin));
        friend.addActionListener(new friendClick(game, penguin));

        hungryPoints = new JTextArea();
        hungryPoints.setText("Health: "+ String.valueOf(hungry));
        hungryPoints.setBounds(550,100,500,50);
        hungryPoints.setOpaque(false);
        hungryPoints.setVisible(true);

        happyPoints = new JTextArea();
        happyPoints.setText("Mood: "+ String.valueOf(happy));
        happyPoints.setBounds(550,150,500,50);
        happyPoints.setOpaque(false);
        happyPoints.setVisible(true);

        Font font = hungryPoints.getFont();
        float size = font.getSize() + 10.0f;
        hungryPoints.setFont( font.deriveFont(size) );
        happyPoints.setFont( font.deriveFont(size) );
        hungryPoints.setForeground(Color.white);
        happyPoints.setForeground(Color.white);



        game.add(food);
        game.add(sleep);
        game.add(friend);
        game.add(penguin);
        game.add(hungryPoints);
        game.add(happyPoints);
        game.setVisible(true);
    }

}

