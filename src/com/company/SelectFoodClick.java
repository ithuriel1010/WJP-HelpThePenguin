package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectFoodClick implements ActionListener {

    foodClick fc1;
    Window game;
    private TimeManagement time;

    SelectFoodClick(Window game, foodClick fc, TimeManagement time)
    {
        this.game=game;
        fc1 = fc;
        this.time=time;
    }

    public void actionPerformed(ActionEvent e)
    {
        time.TimeFunction2();
        JButton b = (JButton) e.getSource();
        int foodConsumed=0;
        int foodConsumed2=0;
        int foodConsumedCalories = 0;

        if(MainGame.eatenFood<=1500)
        {
            if (b==foodClick.pizza)
            {
                foodConsumed+=FoodButtons.pizza.healthPoints;
                MainGame.eatenFood+=FoodButtons.pizza.calories;
                MainGame.happy+=FoodButtons.pizza.happyPoints;

            }
            else if (b==foodClick.chicken)
            {
                foodConsumed+=FoodButtons.chicken.healthPoints;
                MainGame.eatenFood+=FoodButtons.chicken.calories;
                MainGame.happy+=FoodButtons.chicken.happyPoints;

            }
            else if (b==foodClick.sandwich)
            {
                foodConsumed+=FoodButtons.sandwich.healthPoints;
                MainGame.eatenFood+=FoodButtons.sandwich.calories;
                MainGame.happy+=FoodButtons.sandwich.happyPoints;

            }
            else if (b==foodClick.pancake)
            {
                foodConsumed+=FoodButtons.pancake.healthPoints;
                MainGame.eatenFood+=FoodButtons.pancake.calories;
                MainGame.happy+=FoodButtons.pancake.happyPoints;

            }
            else if (b==foodClick.chocolate)
            {
                foodConsumed+=FoodButtons.chocolate.healthPoints;
                MainGame.eatenFood+=FoodButtons.chocolate.calories;
                MainGame.happy+=FoodButtons.chocolate.happyPoints;

            }
            else if (b==foodClick.nuggets)
            {
                foodConsumed+=FoodButtons.nuggets.healthPoints;
                MainGame.eatenFood+=FoodButtons.nuggets.calories;
                MainGame.happy+=FoodButtons.nuggets.happyPoints;

            }
            else if (b==foodClick.dinner)
            {
                foodConsumed+=FoodButtons.dinner.healthPoints;
                MainGame.eatenFood+=FoodButtons.dinner.calories;
                MainGame.happy+=FoodButtons.dinner.happyPoints;

            }
            else if (b==foodClick.fish)
            {
                foodConsumed+=FoodButtons.fish.healthPoints;
                MainGame.eatenFood+=FoodButtons.fish.calories;
                MainGame.happy+=FoodButtons.fish.happyPoints;

            }
            else if (b==foodClick.salad)
            {
                foodConsumed+=FoodButtons.salad.healthPoints;
                MainGame.eatenFood+=FoodButtons.salad.calories;
                MainGame.happy+=FoodButtons.salad.happyPoints;

            }
            MainGame.hungry+=foodConsumed;
        }
        else if(MainGame.eatenFood>=1501)
        {
            if (b==foodClick.pizza)
            {
                foodConsumed2+=FoodButtons.pizza.healthPoints;
                MainGame.eatenFood+=FoodButtons.pizza.calories;
                MainGame.happy-=FoodButtons.pizza.happyPoints;

            }
            else if (b==foodClick.chicken)
            {
                foodConsumed2+=FoodButtons.chicken.healthPoints;
                MainGame.eatenFood+=FoodButtons.chicken.calories;
                MainGame.happy-=FoodButtons.chicken.happyPoints;

            }
            else if (b==foodClick.sandwich)
            {
                foodConsumed2+=FoodButtons.sandwich.healthPoints;
                MainGame.eatenFood+=FoodButtons.sandwich.calories;
                MainGame.happy-=FoodButtons.sandwich.happyPoints;

            }
            else if (b==foodClick.pancake)
            {
                foodConsumed2+=FoodButtons.pancake.healthPoints;
                MainGame.eatenFood+=FoodButtons.pancake.calories;
                MainGame.happy-=FoodButtons.pancake.happyPoints;

            }
            else if (b==foodClick.chocolate)
            {
                foodConsumed2+=FoodButtons.chocolate.healthPoints;
                MainGame.eatenFood+=FoodButtons.chocolate.calories;
                MainGame.happy-=FoodButtons.chocolate.happyPoints;

            }
            else if (b==foodClick.nuggets)
            {
                foodConsumed2+=FoodButtons.nuggets.healthPoints;
                MainGame.eatenFood+=FoodButtons.nuggets.calories;
                MainGame.happy-=FoodButtons.nuggets.happyPoints;

            }
            else if (b==foodClick.dinner)
            {
                foodConsumed2+=FoodButtons.dinner.healthPoints;
                MainGame.eatenFood+=FoodButtons.dinner.calories;
                MainGame.happy-=FoodButtons.dinner.happyPoints;

            }
            else if (b==foodClick.fish)
            {
                foodConsumed2+=FoodButtons.fish.healthPoints;
                MainGame.eatenFood+=FoodButtons.fish.calories;
                MainGame.happy-=FoodButtons.fish.happyPoints;

            }
            else if (b==foodClick.salad)
            {
                foodConsumed2+=FoodButtons.salad.healthPoints;
                MainGame.eatenFood+=FoodButtons.salad.calories;
                MainGame.happy-=FoodButtons.salad.happyPoints;

            }

            MainGame.hungry-=foodConsumed2;
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


        MainGame.hungryPoints.setText("Health: "+ String.valueOf(MainGame.hungry));
        MainGame.happyPoints.setText("Mood: "+ String.valueOf(MainGame.happy));

        game.add(MainGame.hungryPoints);
        game.add(MainGame.happyPoints);

    }
}
