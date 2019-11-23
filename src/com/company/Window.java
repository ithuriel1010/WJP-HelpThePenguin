package com.company;

import javax.swing.*;

public class Window extends JFrame {

    Window(String nazwa, double width, double height, double xcenter, double ycenter)
    {
        super(nazwa);
        int width2 = (int)width;
        int height2 = (int)height;
        setResizable(false);
        setSize(width2,height2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
