package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class foodClick implements ActionListener {

    public Window g;
    public static Window w;
    public static JButton penguin;
    //public JPanel foods = new JPanel();
    final JPanel foods = new TransparentPanel();
    public  JTextArea info4 = new JTextArea();
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
        createFoods();
        foods.setVisible(false);
    }


    public void actionPerformed(ActionEvent e)
    {
        //JPanel foods = new JPanel();
        foods.setVisible(true);
        g.ButtonImage(penguin,"D:/Studia/Semestr V/Współczesne języki programowania/Projekt/Penguin/eatingPenguin2.png",500,295,false);

    }

    private class TransparentPanel extends JPanel {
        {
            setOpaque(false);
        }
        public void paintComponent(Graphics g) {
            g.setColor(getBackground());
            Rectangle r = g.getClipBounds();
            g.fillRect(r.x, r.y, r.width, r.height);
            super.paintComponent(g);
        }
    }

    private void createFoods() {
        foods.setBounds(0, 0, 500, 550);
        //foods.setOpaque(true);
        foods.setBackground(new Color(211,211,211,125));
        //JPanel p2=new JPanel();
        //foods.setBackground(Color.LIGHT_GRAY);

        JTextArea info = new JTextArea();
        info.setText("Wybierz co ma zjeść pingwinek!");
        info.setOpaque(false);

        JTextArea info2 = new JTextArea();
        info2.setText("Pamiętaj że istotne jest co i ile jesz!");
        info2.setOpaque(false);

        JTextArea info3 = new JTextArea();
        info3.setText("Zdrowa dieta jest bardzo ważna. Pamiętaj że mimo iż niektóre potrawy \nsą smaczne i poprawiją nam humor, nie zawsze są one zdrowe \nw nadmiernej ilości!");
        info3.setOpaque(false);
        info3.setVisible(true);

        info4.setText("O nie! Pingwinek jest przekarmiony! Kiedy jesz niezdrowe jedzenie \n(lub nadmierną ilość zdrowego!) jest to dla ciebie niezdrowe. \nTeraz każda większa ilość jedzenia będzie zła dla pingwinka");
        info4.setOpaque(false);
        info4.setVisible(false);



        Font font = info.getFont();
        float size = font.getSize() + 2.0f;
        float size2 = font.getSize() + 4.0f;

        info.setFont( font.deriveFont(size) );
        info2.setFont( font.deriveFont(size) );
        info3.setFont( font.deriveFont(size) );
        info4.setFont(font.deriveFont(size2));
        info4.setForeground(Color.RED);


        JButton ok = new JButton();
        ok.setText("Zakończ karmienie");
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                foods.setVisible(false);
                //foods.remove(info4);
                //g.remove(foods);
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

        chicken.addActionListener(new SelectFoodClick(g, this));
        pizza.addActionListener(new SelectFoodClick(g, this));
        sandwich.addActionListener(new SelectFoodClick(g, this));
        pancake.addActionListener(new SelectFoodClick(g, this));
        chocolate.addActionListener(new SelectFoodClick(g, this));
        nuggets.addActionListener(new SelectFoodClick(g, this));
        dinner.addActionListener(new SelectFoodClick(g, this));
        fish.addActionListener(new SelectFoodClick(g,this));
        salad.addActionListener(new SelectFoodClick(g,this));


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
        foods.add(info3);
        foods.add(ok);
        foods.add(info4);


        foods.setVisible(true);

        g.add(foods);
    }

    public void TooMuchFood()
    {


        info4.setVisible(true);

        foods.add(info4);
        g.add(foods);
        //g.setVisible(true);
    }
}
