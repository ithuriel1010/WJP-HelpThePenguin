package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class foodClick implements ActionListener {

    public Window g;
    public Window w;
    public JButton penguin;
    static public JButton pizza;
    static public JButton chicken;
    static public JButton sandwich;
    static public JButton pancake;
    static public JButton chocolate;
    static public JButton nuggets;
    static public JButton dinner;
    static public JButton fish;
    static public JButton salad;


    public foodClick(Window gameWindow, JButton penguin) {
        g = gameWindow;
        w = new Window();
        this.penguin=penguin;
    }


    public void actionPerformed(ActionEvent e)
    {
        JPanel foods = new JPanel();
        foods.setBounds(0, 0, 500, 500);
        foods.setOpaque(true);
        foods.setBackground(Color.BLUE);

        JTextArea info = new JTextArea();
        info.setText("Wybierz co ma zjeść pingwinek!");
        info.setOpaque(false);

        JTextArea info2 = new JTextArea();
        info2.setText("Pamiętaj że istotne jest co i ile jesz!");
        info2.setOpaque(false);

        Font font = info.getFont();
        float size = font.getSize() + 2.0f;
        info.setFont( font.deriveFont(size) );
        info2.setFont( font.deriveFont(size) );

        JButton ok = new JButton();
        ok.setText("Zakończ karmienie");
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                foods.setVisible(false);
                //allSleepInfo.setVisible(false);
                g.remove(foods);
                g.ButtonImage(penguin,"D:/Studia/Semestr V/Współczesne języki programowania/Projekt/Penguin/HappyPenguin.png",500,275,false);
            }
        });


        pizza = new JButton();
        chicken = new JButton();
        sandwich = new JButton();
        pancake = new JButton();
        chocolate = new JButton();
        nuggets = new JButton();
        dinner = new JButton();
        fish = new JButton();
        salad = new JButton();


        g.ButtonImage(chicken, "D:/Studia/Semestr V/Współczesne języki programowania/Projekt/Foods/FoodMenu/chicken.png",0,100,false);
        g.ButtonImage(pizza, "D:/Studia/Semestr V/Współczesne języki programowania/Projekt/Foods/FoodMenu/pizza.png",110,0,false);
        g.ButtonImage(sandwich, "D:/Studia/Semestr V/Współczesne języki programowania/Projekt/Foods/FoodMenu/sandwich.png",220,0,false);
        g.ButtonImage(pancake, "D:/Studia/Semestr V/Współczesne języki programowania/Projekt/Foods/FoodMenu/pancakes.png",0,110,false);
        g.ButtonImage(chocolate, "D:/Studia/Semestr V/Współczesne języki programowania/Projekt/Foods/FoodMenu/chocolate.png",110,110,false);
        g.ButtonImage(nuggets, "D:/Studia/Semestr V/Współczesne języki programowania/Projekt/Foods/FoodMenu/nuggets.png",220,110,false);
        g.ButtonImage(dinner, "D:/Studia/Semestr V/Współczesne języki programowania/Projekt/Foods/FoodMenu/dinner.png",0,2200,false);
        g.ButtonImage(fish, "D:/Studia/Semestr V/Współczesne języki programowania/Projekt/Foods/FoodMenu/fish.png",0,2200,false);
        g.ButtonImage(salad, "D:/Studia/Semestr V/Współczesne języki programowania/Projekt/Foods/FoodMenu/salad.png",0,2200,false);

        chicken.addActionListener(new SelectFoodClick(g));
        pizza.addActionListener(new SelectFoodClick(g));
        sandwich.addActionListener(new SelectFoodClick(g));
        pancake.addActionListener(new SelectFoodClick(g));
        chocolate.addActionListener(new SelectFoodClick(g));
        nuggets.addActionListener(new SelectFoodClick(g));
        dinner.addActionListener(new SelectFoodClick(g));
        fish.addActionListener(new SelectFoodClick(g));
        salad.addActionListener(new SelectFoodClick(g));


        foods.add(info);
        foods.add(info2);
        foods.add(chicken);
        foods.add(pizza);
        foods.add(sandwich);
        foods.add(pancake);
        foods.add(chocolate);
        foods.add(nuggets);
        foods.add(dinner);
        foods.add(fish);
        foods.add(salad);
        foods.add(ok);

        g.ButtonImage(penguin,"D:/Studia/Semestr V/Współczesne języki programowania/Projekt/Penguin/eatingPenguin.png",500,295,false);

        foods.setVisible(true);

        g.add(foods);
        g.setVisible(true);
    }
}
