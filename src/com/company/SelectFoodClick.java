package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectFoodClick implements ActionListener {

    foodClick fc1;
    Window game;
    private TimeManagement time;
    MainGame game2;

    SelectFoodClick(Window game, foodClick fc, TimeManagement time, MainGame game2)
    {
        this.game=game;
        fc1 = fc;
        this.time=time;
        this.game2=game2;
    }

    public void actionPerformed(ActionEvent e)
    {
        time.TimeFunction2();
        JButton b = (JButton) e.getSource();
        int foodConsumed=0;
        int foodConsumed2=0;
        int foodConsumedCalories = 0;

        if(game2.eatenFood<=1500)
        {
            if (b==foodClick.pizza)
            {
                foodConsumed+=FoodButtons.pizza.healthPoints;
                game2.eatenFood+=FoodButtons.pizza.calories;
                game2.happy+=FoodButtons.pizza.happyPoints;

            }
            else if (b==foodClick.chicken)
            {
                foodConsumed+=FoodButtons.chicken.healthPoints;
                game2.eatenFood+=FoodButtons.chicken.calories;
                game2.happy+=FoodButtons.chicken.happyPoints;

            }
            else if (b==foodClick.sandwich)
            {
                foodConsumed+=FoodButtons.sandwich.healthPoints;
                game2.eatenFood+=FoodButtons.sandwich.calories;
                game2.happy+=FoodButtons.sandwich.happyPoints;

            }
            else if (b==foodClick.pancake)
            {
                foodConsumed+=FoodButtons.pancake.healthPoints;
                game2.eatenFood+=FoodButtons.pancake.calories;
                game2.happy+=FoodButtons.pancake.happyPoints;

            }
            else if (b==foodClick.chocolate)
            {
                foodConsumed+=FoodButtons.chocolate.healthPoints;
                game2.eatenFood+=FoodButtons.chocolate.calories;
                game2.happy+=FoodButtons.chocolate.happyPoints;

            }
            else if (b==foodClick.nuggets)
            {
                foodConsumed+=FoodButtons.nuggets.healthPoints;
                game2.eatenFood+=FoodButtons.nuggets.calories;
                game2.happy+=FoodButtons.nuggets.happyPoints;

            }
            else if (b==foodClick.dinner)
            {
                foodConsumed+=FoodButtons.dinner.healthPoints;
                game2.eatenFood+=FoodButtons.dinner.calories;
                game2.happy+=FoodButtons.dinner.happyPoints;

            }
            else if (b==foodClick.fish)
            {
                foodConsumed+=FoodButtons.fish.healthPoints;
                game2.eatenFood+=FoodButtons.fish.calories;
                game2.happy+=FoodButtons.fish.happyPoints;

            }
            else if (b==foodClick.salad)
            {
                foodConsumed+=FoodButtons.salad.healthPoints;
                game2.eatenFood+=FoodButtons.salad.calories;
                game2.happy+=FoodButtons.salad.happyPoints;

            }
            game2.hungry+=foodConsumed;
        }
        else if(game2.eatenFood>=1501)
        {
            if (b==foodClick.pizza)
            {
                foodConsumed2+=FoodButtons.pizza.healthPoints;
                game2.eatenFood+=FoodButtons.pizza.calories;
                game2.happy-=FoodButtons.pizza.happyPoints;

            }
            else if (b==foodClick.chicken)
            {
                foodConsumed2+=FoodButtons.chicken.healthPoints;
                game2.eatenFood+=FoodButtons.chicken.calories;
                game2.happy-=FoodButtons.chicken.happyPoints;

            }
            else if (b==foodClick.sandwich)
            {
                foodConsumed2+=FoodButtons.sandwich.healthPoints;
                game2.eatenFood+=FoodButtons.sandwich.calories;
                game2.happy-=FoodButtons.sandwich.happyPoints;

            }
            else if (b==foodClick.pancake)
            {
                foodConsumed2+=FoodButtons.pancake.healthPoints;
                game2.eatenFood+=FoodButtons.pancake.calories;
                game2.happy-=FoodButtons.pancake.happyPoints;

            }
            else if (b==foodClick.chocolate)
            {
                foodConsumed2+=FoodButtons.chocolate.healthPoints;
                game2.eatenFood+=FoodButtons.chocolate.calories;
                game2.happy-=FoodButtons.chocolate.happyPoints;

            }
            else if (b==foodClick.nuggets)
            {
                foodConsumed2+=FoodButtons.nuggets.healthPoints;
                game2.eatenFood+=FoodButtons.nuggets.calories;
                game2.happy-=FoodButtons.nuggets.happyPoints;

            }
            else if (b==foodClick.dinner)
            {
                foodConsumed2+=FoodButtons.dinner.healthPoints;
                game2.eatenFood+=FoodButtons.dinner.calories;
                game2.happy-=FoodButtons.dinner.happyPoints;

            }
            else if (b==foodClick.fish)
            {
                foodConsumed2+=FoodButtons.fish.healthPoints;
                game2.eatenFood+=FoodButtons.fish.calories;
                game2.happy-=FoodButtons.fish.happyPoints;

            }
            else if (b==foodClick.salad)
            {
                foodConsumed2+=FoodButtons.salad.healthPoints;
                game2.eatenFood+=FoodButtons.salad.calories;
                game2.happy-=FoodButtons.salad.happyPoints;

            }

            game2.hungry-=foodConsumed2;
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


        game2.hungryPoints.setText("Health: "+ String.valueOf(game2.hungry));
        game2.happyPoints.setText("Mood: "+ String.valueOf(game2.happy));

        game.add(game2.hungryPoints);
        game.add(game2.happyPoints);

    }
}
