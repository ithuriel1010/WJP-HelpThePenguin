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
        gameWindow = gameWindow;
        hugInfo.setEditable(false);
        hugInfo.setOpaque(false);
        hugInfo.setText(Subtitles.hugInfo);
        hugInfo.setBounds(580,130,500,300);
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
    public void actionPerformed(ActionEvent e) {
       JButton b = (JButton) e.getSource();
        Window w = new Window();

        if(game.isWithFriend==false)
        {
            if(penguin_original==true)
            {
                w.ButtonImage(b,"./CutePenguin3.png",515,300,false);
                gameWindow.setVisible(true);
                hugInfo.setVisible(true);
                penguin_original=false;
            }
            else if (penguin_original==false){
                hugInfo.setVisible(false);
                w.ButtonImage(b, "./Pengiun2.png", 480, 285, false);
                penguin_original = true;
            }
            gameWindow.add(hugInfo);
            gameWindow.setVisible(true);
        }
        else if(game.isWithFriend==true)
        {
            if(penguin_original_with_friend==true)
            {
                //hugInfo.setVisible(true);
                w.ButtonImage(b,"./coolPenguin2.png",350,350,false);
                penguin_original_with_friend=false;
            }
            else if (penguin_original_with_friend==false){
                //hugInfo.setVisible(false);
                w.ButtonImage(b, "./veryHappy2.png", 350,350, false);
                penguin_original_with_friend = true;
            }
            //hugInfo.setVisible(true);
            //gra2.add(hugInfo);
            gameWindow.setVisible(true);
        }

    }
}
