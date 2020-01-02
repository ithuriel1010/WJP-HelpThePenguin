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
    public MainGame game;


    public friendClick(Window gameWindow, JButton penguin, MainGame game) {
        g = gameWindow;
        this.penguin=penguin;
        this.game=game;
    }

    public void actionPerformed(ActionEvent e)
    {
        MainGame.isWithFriend=true;
        try
        {
            g.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("./Cartoon_Forest_BG_02.png")))));
        }
        catch(Exception m)
        {
            System.out.println("Błąd pliku backgroung");
        }

        g.ButtonImage(penguin,"./veryHappy2.png",350,350,false);
        g.ButtonImage(panda,"./HappyPanda2.png",650,350,false);

        g.ButtonImage(leave,"./Lave.png",0,0,true);
        leave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                MainGame.isWithFriend=false;
                g.ButtonImage(penguin,"./Pengiun2.png",500,275,false);

                try
                {
                    g.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("./snowy01_preview-01.png")))));
                }
                catch(Exception m)
                {
                    System.out.println("Błąd pliku backgroung");
                }

                g.remove(panda);
                g.remove(leave);

                g.add(MainGame.food);
                g.add(MainGame.sleep);
                g.add(MainGame.friend);
                g.add(penguin);
                g.add(game.hungryPoints);
                g.add(game.happyPoints);
                g.setVisible(true);



            }
        });

        JPanel info = new JPanel();
        info.setBounds(800, 200, 800, 500);
        info.setOpaque(false);

        JTextArea friendInfo = new JTextArea();
        friendInfo.setText(Subtitles.friendInfo);
        //friendInfo.setLocation(1000,200);
        //friendInfo.setBackground(Color.PINK);
        friendInfo.setForeground(Color.white);
        friendInfo.setOpaque(false);
        friendInfo.setVisible(true);


        game.happy+=500;
        game.happyPoints.setText("Mood: "+ String.valueOf(game.happy));
        info.add(friendInfo);

        Font font = friendInfo.getFont();
        float size = font.getSize() + 13.0f;
        friendInfo.setFont( font.deriveFont(size) );

        panda.addActionListener(new pandaClick(g));

        g.add(penguin);
        g.add(panda);
        g.add(game.happyPoints);
        g.add(game.hungryPoints);
        g.add(leave);
        g.add(info);

        g.setVisible(true);
    }
}
