package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FoodClick implements ActionListener {

    public Window gameWindow;
    public JButton penguin;
    final JPanel foods = new TransparentPanel();
    public  JTextArea info4 = new JTextArea();
    public JButton pizza;
    public JButton chicken;
    public JButton sandwich;
    public JButton pancake;
    public JButton chocolate;
    public JButton nuggets;
    public JButton dinner;
    public JButton fish;
    public JButton salad;
    private TimeManagement time;
    private MainGame game;


    public FoodClick(Window gameWindow, JButton penguin, TimeManagement time, MainGame game) {
        this.gameWindow = gameWindow;
        this.time=time;
        this.time.setFood(this);
        this.penguin=penguin;
        this.game=game;
        createFoods();
        foods.setVisible(false);

    }

    public void actionPerformed(ActionEvent e)
    {
        if(game.sleepMenuOpen==false)   //Sprawdzenie czy okno snu nie jest otwarte i jego ewentualne zamykanie
        {
            game.foodMenuOpen=true;
        }
        else if(game.sleepMenuOpen==true)
        {
            game.sleepClick.ZakonczSpanie();
            game.foodMenuOpen=true;
        }

        if(game.eatenFood>=1501)            //Sprawdzenie czy ilość podanych pingwinowi kalorii nie jest za duża i wywoływanie odpowiednich metod jeśli tak
        {
            TooMuchFood();
        }
        else
        {
            info4.setVisible(false);
            foods.add(info4);
            gameWindow.add(foods);
        }

        foods.setVisible(true);
        gameWindow.ButtonImage(penguin,"./eatingPenguin2.png",500,295,false);

    }

    private class TransparentPanel extends JPanel {         //Tworzenie pół-przezroczystego panelu
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

    private void createFoods() {                                //Tworzenie panelu foods z instrukcjami i guzikami jedzenia
        foods.setBounds(0, 0, 500, 550);
        foods.setBackground(new Color(211,211,211,125));

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

        JButton endOfFeeding = new JButton();
        endOfFeeding.setText("Zakończ karmienie");
        endOfFeeding.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ZakonczKarmienie();
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

        //Przypisanie obrazka i miejsca każdego guzika jedzenia
        gameWindow.ButtonImage(chicken, "./chicken.png",0,100,false);
        gameWindow.ButtonImage(pizza, "./pizza.png",110,0,false);
        gameWindow.ButtonImage(sandwich, "./sandwich.png",220,0,false);
        gameWindow.ButtonImage(pancake, "./pancakes.png",0,110,false);
        gameWindow.ButtonImage(chocolate, "./chocolate.png",110,110,false);
        gameWindow.ButtonImage(nuggets, "./nuggets.png",220,110,false);
        gameWindow.ButtonImage(dinner, "./dinner.png",0,2200,false);
        gameWindow.ButtonImage(fish, "./fish.png",0,2200,false);
        gameWindow.ButtonImage(salad, "./salad.png",0,2200,false);

        chicken.addActionListener(new SelectFoodClick(gameWindow, this, time, game));
        pizza.addActionListener(new SelectFoodClick(gameWindow, this, time, game));
        sandwich.addActionListener(new SelectFoodClick(gameWindow, this, time, game));
        pancake.addActionListener(new SelectFoodClick(gameWindow, this, time, game));
        chocolate.addActionListener(new SelectFoodClick(gameWindow, this, time, game));
        nuggets.addActionListener(new SelectFoodClick(gameWindow, this, time, game));
        dinner.addActionListener(new SelectFoodClick(gameWindow, this, time, game));
        fish.addActionListener(new SelectFoodClick(gameWindow,this, time, game));
        salad.addActionListener(new SelectFoodClick(gameWindow,this, time, game));

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
        foods.add(endOfFeeding);
        foods.add(info4);

        foods.setVisible(true);

        gameWindow.add(foods);
    }

    public void ZakonczKarmienie()      //Metoda zamykająca panel jedzenia
    {
        game.foodMenuOpen=false;
        foods.setVisible(false);
        gameWindow.ButtonImage(penguin,"./Pengiun2.png",315,275,false);
    }

    public void TooMuchFood()           //Metoda wyświetlająca ostrzeżenie o przekarmieniu pingwinka
    {
        info4.setVisible(true);
        foods.add(info4);
        gameWindow.add(foods);
    }

    public void PenguinCanEat()         //Metoda zmniejszająca ilość zjedzonego przez pingwinka jedzenia (Wywołowana co 30 sekund w klasie TimeManagement)
    {
        game.eatenFood-=100;
        if(game.eatenFood<=0)
        {
            game.eatenFood=0;
        }
    }
}
