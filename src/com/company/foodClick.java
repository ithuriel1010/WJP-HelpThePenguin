package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class foodClick implements ActionListener {

    public Window g;
    public Window w;

    public foodClick(Window gameWindow) {
        g = gameWindow;
        w = new Window();
    }


    public void actionPerformed(ActionEvent e)
    {
        JPanel foods = new JPanel();
        foods.setBounds(0, 0, 500, 500);
        foods.setOpaque(true);
        foods.setBackground(Color.BLUE);

        JButton pizza = new JButton();
        JButton chicken = new JButton();
        JButton sandwich = new JButton();
        JButton pancake = new JButton();
        JButton chocolate = new JButton();
        JButton nuggets = new JButton();
        JButton dinner = new JButton();
        JButton fish = new JButton();
        JButton salad = new JButton();


        g.ButtonImage(chicken, "D:/Studia/Semestr V/Współczesne języki programowania/Projekt/Foods/FoodMenu/chicken.png",0,0,false);
        g.ButtonImage(pizza, "D:/Studia/Semestr V/Współczesne języki programowania/Projekt/Foods/FoodMenu/pizza.png",110,0,false);
        g.ButtonImage(sandwich, "D:/Studia/Semestr V/Współczesne języki programowania/Projekt/Foods/FoodMenu/sandwich.png",220,0,false);
        g.ButtonImage(pancake, "D:/Studia/Semestr V/Współczesne języki programowania/Projekt/Foods/FoodMenu/pancakes.png",0,110,false);
        g.ButtonImage(chocolate, "D:/Studia/Semestr V/Współczesne języki programowania/Projekt/Foods/FoodMenu/chocolate.png",110,110,false);
        g.ButtonImage(nuggets, "D:/Studia/Semestr V/Współczesne języki programowania/Projekt/Foods/FoodMenu/nuggets.png",220,110,false);
        g.ButtonImage(dinner, "D:/Studia/Semestr V/Współczesne języki programowania/Projekt/Foods/FoodMenu/dinner.png",0,2200,false);
        g.ButtonImage(fish, "D:/Studia/Semestr V/Współczesne języki programowania/Projekt/Foods/FoodMenu/fish.png",0,2200,false);
        g.ButtonImage(salad, "D:/Studia/Semestr V/Współczesne języki programowania/Projekt/Foods/FoodMenu/salad.png",0,2200,false);

        foods.add(chicken);
        foods.add(pizza);
        foods.add(sandwich);
        foods.add(pancake);
        foods.add(chocolate);
        foods.add(nuggets);
        foods.add(dinner);
        foods.add(fish);
        foods.add(salad);


        foods.setVisible(true);

        g.add(foods);
        g.setVisible(true);
    }
}
