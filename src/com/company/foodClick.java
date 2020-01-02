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
    private TimeManagement time;
    private MainGame game;


    public foodClick(Window gameWindow, JButton penguin, TimeManagement time, MainGame game) {
        g = gameWindow;
        w = new Window();
        this.time=time;
        this.time.setFood(this);
        this.penguin=penguin;
        createFoods();
        foods.setVisible(false);
        this.game=game;
    }

    public foodClick() {

    }


    public void actionPerformed(ActionEvent e)
    {
//        time.TimeFromLastMeal();
        //JPanel foods = new JPanel();
        if(game.eatenFood>=1501)
        {
            TooMuchFood();
        }
        else
        {
            info4.setVisible(false);
            foods.add(info4);
            g.add(foods);
        }
        foods.setVisible(true);
        g.ButtonImage(penguin,"./eatingPenguin2.png",500,295,false);

        // ./plik.png
        // ./katalog/plik.png

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
        info.setText(Subtitles.foodInfo1);
        info.setOpaque(false);

        JTextArea info2 = new JTextArea();
        info2.setText(Subtitles.foodInfo2);
        info2.setOpaque(false);

        JTextArea info3 = new JTextArea();
        info3.setText(Subtitles.foodInfo3);
        info3.setOpaque(false);
        info3.setVisible(true);

        info4.setText(Subtitles.toMuchFood);
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
                g.ButtonImage(penguin,"./Pengiun2.png",500,275,false);
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


        g.ButtonImage(chicken, "./chicken.png",0,100,false);
        g.ButtonImage(pizza, "./pizza.png",110,0,false);
        g.ButtonImage(sandwich, "./sandwich.png",220,0,false);
        g.ButtonImage(pancake, "./pancakes.png",0,110,false);
        g.ButtonImage(chocolate, "./chocolate.png",110,110,false);
        g.ButtonImage(nuggets, "./nuggets.png",220,110,false);
        g.ButtonImage(dinner, "./dinner.png",0,2200,false);
        g.ButtonImage(fish, "./fish.png",0,2200,false);
        g.ButtonImage(salad, "./salad.png",0,2200,false);

        chicken.addActionListener(new SelectFoodClick(g, this, time, game));
        pizza.addActionListener(new SelectFoodClick(g, this, time, game));
        sandwich.addActionListener(new SelectFoodClick(g, this, time, game));
        pancake.addActionListener(new SelectFoodClick(g, this, time, game));
        chocolate.addActionListener(new SelectFoodClick(g, this, time, game));
        nuggets.addActionListener(new SelectFoodClick(g, this, time, game));
        dinner.addActionListener(new SelectFoodClick(g, this, time, game));
        fish.addActionListener(new SelectFoodClick(g,this, time, game));
        salad.addActionListener(new SelectFoodClick(g,this, time, game));


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

    public void PenguinCanEat()
    {
//        info4.setVisible(false);
//        foods.add(info4);
//        g.add(foods);
        MainGame.eatenFood-=100;
        if(game.eatenFood<=0)
        {
            game.eatenFood=0;
        }
    }
}
