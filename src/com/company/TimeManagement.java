package com.company;

public class TimeManagement implements Runnable {

    private FoodClick food;
    private MainGame game;

    public void setFood(FoodClick food) {
        this.food = food;
    }

    public void setGame(MainGame game) {
        this.game = game;
    }

    @Override
    public void run() {
        while(true)
        {
            try{
                Thread.sleep(30000);
            }
            catch (Exception e)
            { }
            if(food != null) {
                food.PenguinCanEat();
            }

            if(game != null)
            {
                game.TimePassed();
            }
        }
    }
}
