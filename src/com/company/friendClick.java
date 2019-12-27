package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class friendClick implements ActionListener {

    public Window g;
    public JButton penguin;
    public JButton panda = new JButton();
    public JButton leave = new JButton();



    public friendClick(Window gameWindow, JButton penguin) {
        g = gameWindow;
        this.penguin=penguin;
    }

    public void actionPerformed(ActionEvent e)
    {
        Main.isWithFriend=true;
        try
        {
            g.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("D:/Studia/Semestr V/Współczesne języki programowania/Projekt/Background/Forest/Cartoon_Forest_BG_02/Cartoon_Forest_BG_02.png")))));
        }
        catch(Exception m)
        {
            System.out.println("Błąd pliku backgroung");
        }

        g.ButtonImage(penguin,"D:/Studia/Semestr V/Współczesne języki programowania/Projekt/Penguin/veryHappy2.png",350,350,false);
        g.ButtonImage(panda,"D:/Studia/Semestr V/Współczesne języki programowania/Projekt/Panda/HappyPanda2.png",650,350,false);

        g.ButtonImage(leave,"D:/Studia/Semestr V/Współczesne języki programowania/Projekt/Lave.png",0,0,true);
        leave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Main.isWithFriend=false;
                g.ButtonImage(penguin,"D:/Studia/Semestr V/Współczesne języki programowania/Projekt/Penguin/Pengiun2.png.png",500,275,false);

                try
                {
                    g.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("D:/Studia/Semestr V/Współczesne języki programowania/Projekt/Background/Snowy/01/snowy01_preview-01.png")))));
                }
                catch(Exception m)
                {
                    System.out.println("Błąd pliku backgroung");
                }

                g.remove(panda);
                g.remove(leave);

                g.add(Main.food);
                g.add(Main.sleep);
                g.add(Main.friend);
                g.add(penguin);
                g.add(Main.hungryPoints);
                g.add(Main.happyPoints);
                g.setVisible(true);



            }
        });

        JPanel info = new JPanel();
        info.setBounds(800, 200, 800, 500);
        info.setOpaque(false);

        JTextArea friendInfo = new JTextArea();
        friendInfo.setText("Spotkania z przyjaciółmi lub rodziną są dla ciebie \n bardzo dobre! \n Musisz jednak pamiętać aby były to przyjaźnie \n zdrowe!");
        //friendInfo.setLocation(1000,200);
        //friendInfo.setBackground(Color.PINK);
        friendInfo.setForeground(Color.white);
        friendInfo.setOpaque(false);
        friendInfo.setVisible(true);


        Main.happy+=500;
        Main.happyPoints.setText("Mood: "+ String.valueOf(Main.happy));
        info.add(friendInfo);

        Font font = friendInfo.getFont();
        float size = font.getSize() + 13.0f;
        friendInfo.setFont( font.deriveFont(size) );

        panda.addActionListener(new pandaClick(g));

        g.add(penguin);
        g.add(panda);
        g.add(Main.happyPoints);
        g.add(Main.hungryPoints);
        g.add(leave);
        g.add(info);

        g.setVisible(true);
    }
}
