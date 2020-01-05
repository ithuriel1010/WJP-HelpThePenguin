package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PenguinClick implements ActionListener {

    Window gameWindow;
    JTextArea hugInfo = new JTextArea();
    public MainGame game;

    public PenguinClick(Window gameWindow, MainGame game)
    {
        this.gameWindow = gameWindow;
        hugInfo.setEditable(false);
        hugInfo.setOpaque(false);
        hugInfo.setText(Subtitles.hugInfo);
        hugInfo.setBounds(380,130,500,300);
        Font font = hugInfo.getFont();
        float size = font.getSize() + 10.0f;
        hugInfo.setFont( font.deriveFont(size) );
        hugInfo.setForeground(Color.white);
        gameWindow.add(hugInfo);
        hugInfo.setVisible(false);
        this.game =game;
    }

    boolean penguin_original = true;
    boolean penguin_original_with_friend = true;
    public void actionPerformed(ActionEvent e) {                 //Po kliknięciu na pingwina zmienia się jego obrazek
       JButton b = (JButton) e.getSource();
        Window w = new Window();

        if(game.isWithFriend==false)            //Sprawdzenie czy pingwin jest u przyjaciela (jeśli tak to jego obrazek i położenie są inne niż w domu)
        {
            if(penguin_original==true)          //Sprawdzenie który obrazek jest aktualnie przypisany do pingwina i jego zmiana na drugi
            {
                w.ButtonImage(b,"./res/CutePenguin3.png",315,300,false);
                gameWindow.setVisible(true);
                hugInfo.setVisible(true);          //Wyświetlenie informacji o przytulaniu
                penguin_original=false;
            }
            else if (penguin_original==false){
                hugInfo.setVisible(false);
                w.ButtonImage(b, "./res/Pengiun2.png", 280, 285, false);
                penguin_original = true;
            }
            gameWindow.add(hugInfo);
            gameWindow.setVisible(true);
        }
        else if(game.isWithFriend==true)
        {
            if(penguin_original_with_friend==true)
            {
                w.ButtonImage(b,"./res/coolPenguin2.png",350,310,false);
                penguin_original_with_friend=false;
            }
            else if (penguin_original_with_friend==false){
                w.ButtonImage(b, "./res/veryHappy2.png", 350,310, false);
                penguin_original_with_friend = true;
            }
            gameWindow.setVisible(true);
        }
    }
}
