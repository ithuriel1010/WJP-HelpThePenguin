package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class penguinClick implements ActionListener {

    Window gra2;
    JTextArea hugInfo = new JTextArea();

    public penguinClick(Window game)
    {
        gra2 = game;
        hugInfo.setEditable(false);
        hugInfo.setOpaque(false);
        hugInfo.setText(Subtitles.hugInfo);
        hugInfo.setBounds(580,130,500,300);
        Font font = hugInfo.getFont();
        float size = font.getSize() + 10.0f;
        hugInfo.setFont( font.deriveFont(size) );
        hugInfo.setForeground(Color.white);
    }

    boolean penguin_original = true;
    boolean penguin_original_with_friend = true;
    public void actionPerformed(ActionEvent e) {
       JButton b = (JButton) e.getSource();
        Window w = new Window();

        if(MainGame.isWithFriend==false)
        {
            if(penguin_original==true)
            {
                hugInfo.setVisible(true);
                w.ButtonImage(b,"./CutePenguin3.png",515,300,false);
                penguin_original=false;
                gra2.add(hugInfo);
                gra2.setVisible(true);
            }
            else if (penguin_original==false){
                hugInfo.setVisible(false);
                w.ButtonImage(b, "./Pengiun2.png", 480, 285, false);
                penguin_original = true;
            }
            gra2.add(hugInfo);
            gra2.setVisible(true);
        }
        else if(MainGame.isWithFriend==true)
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
            gra2.setVisible(true);
        }

    }
}
