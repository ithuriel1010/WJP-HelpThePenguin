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
        }
        else if (b==foodClick.chicken)
        {
            Main.hungry+=FoodButtons.chicken.healthPoints;
        }
        else if (b==foodClick.sandwich)
        {
            Main.hungry+=FoodButtons.sandwich.healthPoints;
        }
        else if (b==foodClick.pancake)
        {
            Main.hungry+=FoodButtons.pancake.healthPoints;
        }
        else if (b==foodClick.chocolate)
        {
            Main.hungry+=FoodButtons.chocolate.healthPoints;
        }
        else if (b==foodClick.nuggets)
        {
            Main.hungry+=FoodButtons.nuggets.healthPoints;
        }
        else if (b==foodClick.dinner)
        {
            Main.hungry+=FoodButtons.dinner.healthPoints;
        }
        else if (b==foodClick.fish)
        {
            Main.hungry+=FoodButtons.fish.healthPoints;
        }
        else if (b==foodClick.salad)
        {
            Main.hungry+=FoodButtons.salad.healthPoints;
        }

        Main.hungryPoints.setText("Health: "+ String.valueOf(Main.hungry));
        game.add(Main.hungryPoints);

    }
}
