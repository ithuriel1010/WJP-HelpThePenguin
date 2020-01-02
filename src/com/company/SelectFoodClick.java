package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectFoodClick implements ActionListener {

    //foodClick fc1;
    Window gameWindow;
    private TimeManagement time;
    MainGame game;
    FoodClick food;

    SelectFoodClick(Window gameWindow, FoodClick food, TimeManagement time, MainGame game)
    {
        this.gameWindow =gameWindow;
        this.food = food;
        this.time=time;
        this.game =game;
    }

    public void actionPerformed(ActionEvent e)
    {
        //time.TimeFunction2();
        JButton b = (JButton) e.getSource();
        int foodConsumed=0;
        int foodConsumed2=0;
        int foodConsumedCalories = 0;

        if(game.eatenFood<=1500)
        {
            if (b==food.pizza)
            {
                foodConsumed+=FoodButtons.pizza.healthPoints;
                game.eatenFood+=FoodButtons.pizza.calories;
                game.happy+=FoodButtons.pizza.happyPoints;

            }
            else if (b==food.chicken)
            {
                foodConsumed+=FoodButtons.chicken.healthPoints;
                game.eatenFood+=FoodButtons.chicken.calories;
                game.happy+=FoodButtons.chicken.happyPoints;

            }
            else if (b==food.sandwich)
            {
                foodConsumed+=FoodButtons.sandwich.healthPoints;
                game.eatenFood+=FoodButtons.sandwich.calories;
                game.happy+=FoodButtons.sandwich.happyPoints;

            }
            else if (b==food.pancake)
            {
                foodConsumed+=FoodButtons.pancake.healthPoints;
                game.eatenFood+=FoodButtons.pancake.calories;
                game.happy+=FoodButtons.pancake.happyPoints;

            }
            else if (b==food.chocolate)
            {
                foodConsumed+=FoodButtons.chocolate.healthPoints;
                game.eatenFood+=FoodButtons.chocolate.calories;
                game.happy+=FoodButtons.chocolate.happyPoints;

            }
            else if (b==food.nuggets)
            {
                foodConsumed+=FoodButtons.nuggets.healthPoints;
                game.eatenFood+=FoodButtons.nuggets.calories;
                game.happy+=FoodButtons.nuggets.happyPoints;

            }
            else if (b==food.dinner)
            {
                foodConsumed+=FoodButtons.dinner.healthPoints;
                game.eatenFood+=FoodButtons.dinner.calories;
                game.happy+=FoodButtons.dinner.happyPoints;

            }
            else if (b==food.fish)
            {
                foodConsumed+=FoodButtons.fish.healthPoints;
                game.eatenFood+=FoodButtons.fish.calories;
                game.happy+=FoodButtons.fish.happyPoints;

            }
            else if (b==food.salad)
            {
                foodConsumed+=FoodButtons.salad.healthPoints;
                game.eatenFood+=FoodButtons.salad.calories;
                game.happy+=FoodButtons.salad.happyPoints;

            }
            game.health +=foodConsumed;
        }
        else if(game.eatenFood>=1501)
        {
            if (b==food.pizza)
            {
                foodConsumed2+=FoodButtons.pizza.healthPoints;
                game.eatenFood+=FoodButtons.pizza.calories;
                game.happy-=FoodButtons.pizza.happyPoints;

            }
            else if (b==food.chicken)
            {
                foodConsumed2+=FoodButtons.chicken.healthPoints;
                game.eatenFood+=FoodButtons.chicken.calories;
                game.happy-=FoodButtons.chicken.happyPoints;

            }
            else if (b==food.sandwich)
            {
                foodConsumed2+=FoodButtons.sandwich.healthPoints;
                game.eatenFood+=FoodButtons.sandwich.calories;
                game.happy-=FoodButtons.sandwich.happyPoints;

            }
            else if (b==food.pancake)
            {
                foodConsumed2+=FoodButtons.pancake.healthPoints;
                game.eatenFood+=FoodButtons.pancake.calories;
                game.happy-=FoodButtons.pancake.happyPoints;

            }
            else if (b==food.chocolate)
            {
                foodConsumed2+=FoodButtons.chocolate.healthPoints;
                game.eatenFood+=FoodButtons.chocolate.calories;
                game.happy-=FoodButtons.chocolate.happyPoints;

            }
            else if (b==food.nuggets)
            {
                foodConsumed2+=FoodButtons.nuggets.healthPoints;
                game.eatenFood+=FoodButtons.nuggets.calories;
                game.happy-=FoodButtons.nuggets.happyPoints;

            }
            else if (b==food.dinner)
            {
                foodConsumed2+=FoodButtons.dinner.healthPoints;
                game.eatenFood+=FoodButtons.dinner.calories;
                game.happy-=FoodButtons.dinner.happyPoints;

            }
            else if (b==food.fish)
            {
                foodConsumed2+=FoodButtons.fish.healthPoints;
                game.eatenFood+=FoodButtons.fish.calories;
                game.happy-=FoodButtons.fish.happyPoints;

            }
            else if (b==food.salad)
            {
                foodConsumed2+=FoodButtons.salad.healthPoints;
                game.eatenFood+=FoodButtons.salad.calories;
                game.happy-=FoodButtons.salad.happyPoints;

            }

            game.health -=foodConsumed2;
//
            food.TooMuchFood();
//            JTextArea info4 = new JTextArea();
//
//            info4.setText("O nie! Pingwinek jest przekarmiony! Kiedy jesz niezdrowe jedzenie \n(lub nadmierną ilość zdrowego!) jest to dla ciebie niezdrowe. \nTeraz każda większa ilość jedzenia będzie zła dla pingwinka");
//            info4.setOpaque(false);
//            info4.setVisible(true);
//
//            fc1.foods.add(info4);
//            game.add(fc1.foods);

        }


        game.healthPoints.setText("Health: "+ String.valueOf(game.health));
        game.happyPoints.setText("Mood: "+ String.valueOf(game.happy));

        gameWindow.add(game.healthPoints);
        gameWindow.add(game.happyPoints);

    }
}
