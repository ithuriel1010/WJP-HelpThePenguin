package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class penguinClick implements ActionListener {

    Window gra;
    JTextArea hugInfo = new JTextArea();
    public MainGame game2;

    public penguinClick(Window game, MainGame game2)
    {
        gra = game;
        hugInfo.setEditable(false);
        hugInfo.setOpaque(false);
        hugInfo.setText(Subtitles.hugInfo);
        hugInfo.setBounds(580,130,500,300);
        Font font = hugInfo.getFont();
        float size = font.getSize() + 10.0f;
        hugInfo.setFont( font.deriveFont(size) );
        hugInfo.setForeground(Color.white);
        gra.add(hugInfo);
        hugInfo.setVisible(false);
        this.game2=game2;
    }

    boolean penguin_original = true;
    boolean penguin_original_with_friend = true;
    public void actionPerformed(ActionEvent e) {
       JButton b = (JButton) e.getSource();
        Window w = new Window();

        if(game2.isWithFriend==false)
        {
            if(penguin_original==true)
            {
                w.ButtonImage(b,"./CutePenguin3.png",515,300,false);
                gra.setVisible(true);
                hugInfo.setVisible(true);
                penguin_original=false;
            }
            else if (penguin_original==false){
                hugInfo.setVisible(false);
                w.ButtonImage(b, "./Pengiun2.png", 480, 285, false);
                penguin_original = true;
            }
            gra.add(hugInfo);
            gra.setVisible(true);
        }
        else if(game2.isWithFriend==true)
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
            gra.setVisible(true);
        }

    }
}
