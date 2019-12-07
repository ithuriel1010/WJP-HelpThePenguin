package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectFoodClick implements ActionListener {


    public void actionPerformed(ActionEvent e)
    {
        JButton b = (JButton) e.getSource();

        if (b==foodClick.pizza)
        {
            System.out.println("Wybrales pizze");
        }
        else if (b==foodClick.chicken)
        {
            System.out.println("Wybrales kurczaka");

        }
        else if (b==foodClick.sandwich)
        {
            System.out.println("Wybrales kanapke");

        }
        else if (b==foodClick.pancake)
        {

        }
        else if (b==foodClick.chocolate)
        {

        }
        else if (b==foodClick.nuggets)
        {

        }
        else if (b==foodClick.dinner)
        {

        }
        else if (b==foodClick.fish)
        {

        }else if (b==foodClick.salad)
        {

        }
    }
}
