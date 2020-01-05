package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class MainGame implements ActionListener {

    public int health = 500;        //Początkowa wartość zdrowia
    public int happy = 500;         //Początkowa wartość nastroju
    public int eatenFood = 0;       //Początkowa wartość zjedzenego jedzenia
    public JTextArea healthPoints;
    public JTextArea happyPoints;
    public boolean isWithFriend=false;
    public boolean foodMenuOpen=false;
    public boolean sleepMenuOpen=false;
    public JButton food = new JButton();
    public JButton sleep = new JButton();
    public JButton friend = new JButton();
    public JButton penguin = new JButton();
    public Window gameWindow;
    public JTextArea instruction;
    public JButton goToTheGame;
    public TimeManagement time = new TimeManagement();
    public FoodClick foodClick;
    public SleepClick sleepClick;

    public MainGame(Window gameWindow, JTextArea instruction, JButton goToTheGame) {
        this.gameWindow = gameWindow;
        this.goToTheGame=goToTheGame;
        this.instruction=instruction;
    }

    public void actionPerformed(ActionEvent e)
    {
        //Po kliknięciu guzika "Rozpocznij grę" usuwane są instrukcje i zaczyna się gra:
        gameWindow.remove(instruction);
        gameWindow.remove(goToTheGame);

        Thread t = new Thread(time);        //Zaczęcie nowego thread aby gra była zależna od czasu
        time.setGame(this);
        t.start();

        try
        {
            gameWindow.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("./res/snowy01_preview-01.png")))));
        }
        catch(Exception h)
        {
            System.out.println("Błąd pliku backgroung");
        }

        gameWindow.ButtonImage(food, "./res/Eggs.png",1050,0,true);
        gameWindow.ButtonImage(sleep,"./res/SleepCloud.png",1050,220,true);
        gameWindow.ButtonImage(friend,"./res/Panda2.png",1050,440,true);
        gameWindow.ButtonImage(penguin,"./res/Pengiun2.png",280,285,false);

        penguin.addActionListener(new PenguinClick(gameWindow, this));

        foodClick = new FoodClick(gameWindow, penguin, time, this);
        food.addActionListener(foodClick);

        sleepClick=new SleepClick(gameWindow, penguin,this);
        sleep.addActionListener(sleepClick);

        friend.addActionListener(new FriendClick(gameWindow, penguin,this));

        healthPoints = new JTextArea();
        healthPoints.setText("Health: "+ String.valueOf(health));       //Wyświetlenie wartości zdrowia pingwina
        healthPoints.setBounds(550,50,500,50);
        healthPoints.setOpaque(false);
        healthPoints.setVisible(true);

        happyPoints = new JTextArea();
        happyPoints.setText("Mood: "+ String.valueOf(happy));           //Wyświetlenie wartości humoru pingwina
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

    public void TimePassed()                //Metoda zmniejszająca wartość zdrowia i humoru pingwinka (Wywołowana co 30 sekund w klasie TimeManagement)
    {
        health -=25;
        happy-=25;

        healthPoints.setText("Health: "+ String.valueOf(health));
        happyPoints.setText("Mood: "+ String.valueOf(happy));

        gameWindow.add(healthPoints);
        gameWindow.add(happyPoints);
    }
}
