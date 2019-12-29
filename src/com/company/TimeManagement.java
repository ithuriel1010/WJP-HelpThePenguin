package com.company;

public class TimeManagement implements Runnable {

    public long startTime;
    public long feedTime;
    public long timefromlastmeal;
    public double timefromlastmealseconds;

    private foodClick food;
    private MainGame game;




    public void TimeFunction1()
    {
        startTime=System.currentTimeMillis();
    }

    public void TimeFunction2()
    {
        feedTime=System.currentTimeMillis();
    }

//    public void TimeFromLastMeal()
//    {
//        if(feedTime==0)
//        {
//            return;
//        }
//        timefromlastmeal=System.currentTimeMillis()-feedTime;
//        timefromlastmealseconds=timefromlastmeal/1000.0;
//
//        if(timefromlastmealseconds>=30.0)
//        {
//            //System.out.println("kkkkkkkkkkkkkkkkkkkkkkkk");
//            food.PenguinCanEat();
//        }
//    }

    public void setFood(foodClick food) {
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
                Thread.sleep(3000);
            } catch (Exception e)
            {

            }
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
