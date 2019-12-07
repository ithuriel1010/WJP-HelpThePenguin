package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Window extends JFrame {

    BufferedImage bimg;

    Window(String nazwa, double width, double height, double xcenter, double ycenter)
    {
        super(nazwa);
        int width2 = (int)width;
        int height2 = (int)height;
        setResizable(false);
        setSize(width2,height2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    Window(){}


    public void ButtonImage(JButton b, String file, int layoutX, int layoutY, boolean ramka)
    {
        try
        {
            bimg = ImageIO.read(new File(file));
            int imagewidth = bimg.getWidth();
            int imageheight= bimg.getHeight();
            b.setSize(imagewidth,imageheight);
            b.setIcon(new ImageIcon(bimg));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        b.setOpaque(false);
        b.setContentAreaFilled(false);
        b.setBorderPainted(ramka);
        b.setLocation(new Point(layoutX,layoutY));
        b.setVisible(true);

    }
}
