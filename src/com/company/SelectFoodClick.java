package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectFoodClick implements ActionListener {

    Window game;
    SelectFoodClick(Window game)
    {
        this.game=game;
    }

    public void actionPerformed(ActionEvent e)
    {
        JButton b = (JButton) e.getSource();

        if (b==foodClick.pizza)
        {
            Main.hungry+=FoodButtons.pizza.healthPoints;
            Main.happy+=FoodButtons.pizza.happyPoints;

        }
        else if (b==foodClick.chicken)
        {
            Main.hungry+=FoodButtons.chicken.healthPoints;
            Main.happy+=FoodButtons.chicken.happyPoints;

        }
        else if (b==foodClick.sandwich)
        {
            Main.hungry+=FoodButtons.sandwich.healthPoints;
            Main.happy+=FoodButtons.sandwich.happyPoints;

        }
        else if (b==foodClick.pancake)
        {
            Main.hungry+=FoodButtons.pancake.healthPoints;
            Main.happy+=FoodButtons.pancake.happyPoints;

        }
        else if (b==foodClick.chocolate)
        {
            Main.hungry+=FoodButtons.chocolate.healthPoints;
            Main.happy+=FoodButtons.chocolate.happyPoints;

        }
        else if (b==foodClick.nuggets)
        {
            Main.hungry+=FoodButtons.nuggets.healthPoints;
            Main.happy+=FoodButtons.nuggets.happyPoints;

        }
        else if (b==foodClick.dinner)
        {
            Main.hungry+=FoodButtons.dinner.healthPoints;
            Main.happy+=FoodButtons.dinner.happyPoints;

        }
        else if (b==foodClick.fish)
        {
            Main.hungry+=FoodButtons.fish.healthPoints;
            Main.happy+=FoodButtons.fish.happyPoints;

        }
        else if (b==foodClick.salad)
        {
            Main.hungry+=FoodButtons.salad.healthPoints;
            Main.happy+=FoodButtons.salad.happyPoints;

        }



        Main.hungryPoints.setText("Health: "+ String.valueOf(Main.hungry));
        Main.happyPoints.setText("Mood: "+ String.valueOf(Main.happy));

        game.add(Main.hungryPoints);
        game.add(Main.happyPoints);

    }
}
