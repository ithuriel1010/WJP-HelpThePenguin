package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class MainGame implements ActionListener {

    public int health = 500;
    public int happy = 500;
    public int eatenFood = 0;
    public JTextArea healthPoints;
    public JTextArea happyPoints;
    public boolean isWithFriend=false;
    public JButton food = new JButton();
    public JButton sleep = new JButton();
    public JButton friend = new JButton();
    public JButton penguin = new JButton();
    public Window gameWindow;
    public JTextArea instruction;
    public JButton goToTheGame;
    public TimeManagement time = new TimeManagement();

    public MainGame(Window gameWindow, JTextArea instruction, JButton goToTheGame) {
        this.gameWindow = gameWindow;
        this.goToTheGame=goToTheGame;
        this.instruction=instruction;
    }

    public void actionPerformed(ActionEvent e)
    {
        gameWindow.remove(instruction);
        gameWindow.remove(goToTheGame);

        Thread t = new Thread(time);
        time.setGame(this);
        t.start();

//        time.TimeFunction1();

        try
        {
            gameWindow.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("./snowy01_preview-01.png")))));
        }
        catch(Exception h)
        {
            System.out.println("Błąd pliku backgroung");
        }

        gameWindow.ButtonImage(food, "./Eggs.png",1300,0,true);
        gameWindow.ButtonImage(sleep,"./SleepCloud.png",1300,220,true);
        gameWindow.ButtonImage(friend,"./Panda2.png",1300,440,true);
        gameWindow.ButtonImage(penguin,"./Pengiun2.png",480,285,false);

        penguin.addActionListener(new PenguinClick(gameWindow, this));
        food.addActionListener(new FoodClick(gameWindow, penguin, time, this));
        sleep.addActionListener(new SleepClick(gameWindow, penguin,this));
        friend.addActionListener(new FriendClick(gameWindow, penguin,this));

        healthPoints = new JTextArea();
        healthPoints.setText("Health: "+ String.valueOf(health));
        healthPoints.setBounds(550,50,500,50);
        healthPoints.setOpaque(false);
        healthPoints.setVisible(true);

        happyPoints = new JTextArea();
        happyPoints.setText("Mood: "+ String.valueOf(happy));
        happyPoints.setBounds(550,75,500,50);
        happyPoints.setOpaque(false);
        happyPoints.setVisible(true);

        Font font = healthPoints.getFont();
        float size = font.getSize() + 10.0f;
        healthPoints.setFont( font.deriveFont(size) );
        happyPoints.setFont( font.deriveFont(size) );
        healthPoints.setForeground(Color.white);
        happyPoints.setForeground(Color.white);



        gameWindow.add(food);
        gameWindow.add(sleep);
        gameWindow.add(friend);
        gameWindow.add(penguin);
        gameWindow.add(healthPoints);
        gameWindow.add(happyPoints);

    }

    public void TimePassed()
    {
        health -=25;
        happy-=25;

        healthPoints.setText("Health: "+ String.valueOf(health));
        happyPoints.setText("Mood: "+ String.valueOf(happy));

        gameWindow.add(healthPoints);
        gameWindow.add(happyPoints);

    }
}
