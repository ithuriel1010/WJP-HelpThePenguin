package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class foodClick implements ActionListener {

    public Window g;
    public Window w;

    public foodClick(Window gameWindow) {
        g = gameWindow;
        w = new Window();
    }


    public void actionPerformed(ActionEvent e)
    {

        JPanel foods = new JPanel();
        foods.setBounds(0, 0, 500, 250);
        foods.setOpaque(true);
        //sleepTime.setLocation(new Point(500,200));
        foods.setBackground(Color.PINK);

        JTextArea info = new JTextArea();
        info.setOpaque(false);
        //info.setContentAreaFilled(false);
        //b.setBorderPainted(false);
        info.setText("Wybierz jedzenie, które ma zjeść pingwinek!");
        info.setEditable(false);
        info.setBounds(550, 325, 400, 100);

        foods.add(info);
        foods.setVisible(true);

        g.add(foods);
        g.setVisible(true);
    }
}
