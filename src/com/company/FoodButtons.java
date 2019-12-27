package com.company;

import javax.swing.*;

public class FoodButtons {

    Window w;
    public int calories;
    public int happyPoints;
    public int healthPoints;
    FoodType type;

    FoodButtons(int calories, int happyPoints, int healthPoints, FoodType type)
    {
        this.calories=calories;
        this.happyPoints=happyPoints;
        this.healthPoints=healthPoints;
        this.type=type;
    }

    public static FoodButtons chicken = new FoodButtons(239,100, 100,FoodType.goodfood);
    public static FoodButtons pizza = new FoodButtons(300,100,50,FoodType.fastfood);
    public static FoodButtons sandwich = new FoodButtons(200,100, 100, FoodType.goodfood);
    public static FoodButtons pancake = new FoodButtons(200,100, 75, FoodType.sweets);
    public static FoodButtons chocolate = new FoodButtons(450,100, 10, FoodType.sweets);
    public static FoodButtons fish = new FoodButtons(100,100, 100, FoodType.sweets);
    public static FoodButtons dinner = new FoodButtons(200,100,150, FoodType.goodfood);
    public static FoodButtons nuggets = new FoodButtons(300,100,25, FoodType.fastfood);
    public static FoodButtons salad = new FoodButtons(100,100, 150, FoodType.goodfood);

}
