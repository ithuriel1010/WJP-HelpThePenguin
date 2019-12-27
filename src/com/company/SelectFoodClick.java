package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectFoodClick implements ActionListener {

    foodClick fc1;
    Window game;
    SelectFoodClick(Window game, foodClick fc )
    {
        this.game=game;
        fc1 = fc;
    }

    public void actionPerformed(ActionEvent e)
    {
        JButton b = (JButton) e.getSource();
        int foodConsumed=0;
        int foodConsumed2=0;
        int foodConsumedCalories = 0;

        if(Main.eatenFood<=1500)
        {
            if (b==foodClick.pizza)
            {
                foodConsumed+=FoodButtons.pizza.healthPoints;
                Main.eatenFood+=FoodButtons.pizza.calories;
                Main.happy+=FoodButtons.pizza.happyPoints;

            }
            else if (b==foodClick.chicken)
            {
                foodConsumed+=FoodButtons.chicken.healthPoints;
                Main.eatenFood+=FoodButtons.chicken.calories;
                Main.happy+=FoodButtons.chicken.happyPoints;

            }
            else if (b==foodClick.sandwich)
            {
                foodConsumed+=FoodButtons.sandwich.healthPoints;
                Main.eatenFood+=FoodButtons.sandwich.calories;
                Main.happy+=FoodButtons.sandwich.happyPoints;

            }
            else if (b==foodClick.pancake)
            {
                foodConsumed+=FoodButtons.pancake.healthPoints;
                Main.eatenFood+=FoodButtons.pancake.calories;
                Main.happy+=FoodButtons.pancake.happyPoints;

            }
            else if (b==foodClick.chocolate)
            {
                foodConsumed+=FoodButtons.chocolate.healthPoints;
                Main.eatenFood+=FoodButtons.chocolate.calories;
                Main.happy+=FoodButtons.chocolate.happyPoints;

            }
            else if (b==foodClick.nuggets)
            {
                foodConsumed+=FoodButtons.nuggets.healthPoints;
                Main.eatenFood+=FoodButtons.nuggets.calories;
                Main.happy+=FoodButtons.nuggets.happyPoints;

            }
            else if (b==foodClick.dinner)
            {
                foodConsumed+=FoodButtons.dinner.healthPoints;
                Main.eatenFood+=FoodButtons.dinner.calories;
                Main.happy+=FoodButtons.dinner.happyPoints;

            }
            else if (b==foodClick.fish)
            {
                foodConsumed+=FoodButtons.fish.healthPoints;
                Main.eatenFood+=FoodButtons.fish.calories;
                Main.happy+=FoodButtons.fish.happyPoints;

            }
            else if (b==foodClick.salad)
            {
                foodConsumed+=FoodButtons.salad.healthPoints;
                Main.eatenFood+=FoodButtons.salad.calories;
                Main.happy+=FoodButtons.salad.happyPoints;

            }
            Main.hungry+=foodConsumed;
        }
        else if(Main.eatenFood>=1501)
        {
            if (b==foodClick.pizza)
            {
                foodConsumed2+=FoodButtons.pizza.healthPoints;
                Main.eatenFood+=FoodButtons.pizza.calories;
                Main.happy-=FoodButtons.pizza.happyPoints;

            }
            else if (b==foodClick.chicken)
            {
                foodConsumed2+=FoodButtons.chicken.healthPoints;
                Main.eatenFood+=FoodButtons.chicken.calories;
                Main.happy-=FoodButtons.chicken.happyPoints;

            }
            else if (b==foodClick.sandwich)
            {
                foodConsumed2+=FoodButtons.sandwich.healthPoints;
                Main.eatenFood+=FoodButtons.sandwich.calories;
                Main.happy-=FoodButtons.sandwich.happyPoints;

            }
            else if (b==foodClick.pancake)
            {
                foodConsumed2+=FoodButtons.pancake.healthPoints;
                Main.eatenFood+=FoodButtons.pancake.calories;
                Main.happy-=FoodButtons.pancake.happyPoints;

            }
            else if (b==foodClick.chocolate)
            {
                foodConsumed2+=FoodButtons.chocolate.healthPoints;
                Main.eatenFood+=FoodButtons.chocolate.calories;
                Main.happy-=FoodButtons.chocolate.happyPoints;

            }
            else if (b==foodClick.nuggets)
            {
                foodConsumed2+=FoodButtons.nuggets.healthPoints;
                Main.eatenFood+=FoodButtons.nuggets.calories;
                Main.happy-=FoodButtons.nuggets.happyPoints;

            }
            else if (b==foodClick.dinner)
            {
                foodConsumed2+=FoodButtons.dinner.healthPoints;
                Main.eatenFood+=FoodButtons.dinner.calories;
                Main.happy-=FoodButtons.dinner.happyPoints;

            }
            else if (b==foodClick.fish)
            {
                foodConsumed2+=FoodButtons.fish.healthPoints;
                Main.eatenFood+=FoodButtons.fish.calories;
                Main.happy-=FoodButtons.fish.happyPoints;

            }
            else if (b==foodClick.salad)
            {
                foodConsumed2+=FoodButtons.salad.healthPoints;
                Main.eatenFood+=FoodButtons.salad.calories;
                Main.happy-=FoodButtons.salad.happyPoints;

            }

            Main.hungry-=foodConsumed2;
//
            fc1.TooMuchFood();
//            JTextArea info4 = new JTextArea();
//
//            info4.setText("O nie! Pingwinek jest przekarmiony! Kiedy jesz niezdrowe jedzenie \n(lub nadmierną ilość zdrowego!) jest to dla ciebie niezdrowe. \nTeraz każda większa ilość jedzenia będzie zła dla pingwinka");
//            info4.setOpaque(false);
//            info4.setVisible(true);
//
//            fc1.foods.add(info4);
//            game.add(fc1.foods);

        }


        Main.hungryPoints.setText("Health: "+ String.valueOf(Main.hungry));
        Main.happyPoints.setText("Mood: "+ String.valueOf(Main.happy));

        game.add(Main.hungryPoints);
        game.add(Main.happyPoints);

    }
}
