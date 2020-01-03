package com.company;

public class FoodButtons {

    public int calories;
    public int happyPoints;
    public int healthPoints;

    FoodButtons(int calories, int happyPoints, int healthPoints)
    {
        this.calories=calories;
        this.happyPoints=happyPoints;
        this.healthPoints=healthPoints;
    }

    public static FoodButtons chicken = new FoodButtons(239,100, 100);
    public static FoodButtons pizza = new FoodButtons(300,100,50);
    public static FoodButtons sandwich = new FoodButtons(200,100, 100);
    public static FoodButtons pancake = new FoodButtons(200,100, 75);
    public static FoodButtons chocolate = new FoodButtons(450,100, 10);
    public static FoodButtons fish = new FoodButtons(100,100, 100);
    public static FoodButtons dinner = new FoodButtons(200,100,150);
    public static FoodButtons nuggets = new FoodButtons(300,100,25);
    public static FoodButtons salad = new FoodButtons(100,100, 150);

}
