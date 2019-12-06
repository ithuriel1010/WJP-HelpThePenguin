package com.company;

import javax.swing.*;

public class FoodButtons {

    Window w;
    FoodButtons(JButton button, int calories, int happyPoints, String file, int x, int y)
    {
        w = new Window();
        w.ButtonImage(button, file,x,y,true);

    }
}
