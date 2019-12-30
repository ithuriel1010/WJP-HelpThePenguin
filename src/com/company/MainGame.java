package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class MainGame implements ActionListener {

    public static int hungry = 500;
    public static int happy = 500;
    public static int eatenFood = 0;
    public static JTextArea hungryPoints;
    public static JTextArea happyPoints;
    public static boolean isWithFriend=false;
    public static JButton food = new JButton();
    public static JButton sleep = new JButton();
    public static JButton friend = new JButton();
    public static JButton penguin = new JButton();
    public Window game;
    public JTextArea instruction;
    public JButton goToTheGame;
    public TimeManagement time = new TimeManagement();

    public MainGame(Window gameWindow, JTextArea instruction, JButton goToTheGame) {
        game = gameWindow;
        this.goToTheGame=goToTheGame;
        this.instruction=instruction;
    }

    public void actionPerformed(ActionEvent e)
    {
        game.remove(instruction);
        game.remove(goToTheGame);

        Thread t = new Thread(time);
        time.setGame(this);
        t.start();

//        time.TimeFunction1();

        try
        {
            game.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("./snowy01_preview-01.png")))));
        }
        catch(Exception h)
        {
            System.out.println("Błąd pliku backgroung");
        }

        game.ButtonImage(food, "./Eggs.png",1300,0,true);
        game.ButtonImage(sleep,"./SleepCloud.png",1300,220,true);
        game.ButtonImage(friend,"./Panda2.png",1300,440,true);
        game.ButtonImage(penguin,"./Pengiun2.png",480,285,false);

        penguin.addActionListener(new penguinClick(game));
        food.addActionListener(new foodClick(game, penguin, time, this));
        sleep.addActionListener(new sleepClick(game, penguin));
        friend.addActionListener(new friendClick(game, penguin));

        hungryPoints = new JTextArea();
        hungryPoints.setText("Health: "+ String.valueOf(hungry));
        hungryPoints.setBounds(550,50,500,50);
        hungryPoints.setOpaque(false);
        hungryPoints.setVisible(true);

        happyPoints = new JTextArea();
        happyPoints.setText("Mood: "+ String.valueOf(happy));
        happyPoints.setBounds(550,75,500,50);
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

    }

    public void TimePassed()
    {
        hungry-=25;
        happy-=25;

        hungryPoints.setText("Health: "+ String.valueOf(hungry));
        happyPoints.setText("Mood: "+ String.valueOf(happy));

        game.add(hungryPoints);
        game.add(happyPoints);

    }
}
