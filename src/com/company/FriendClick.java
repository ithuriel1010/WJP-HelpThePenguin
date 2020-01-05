package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class FriendClick implements ActionListener {

    public Window gameWindow;
    public JButton penguin;
    public JButton panda = new JButton();
    public JButton leave = new JButton();
    public MainGame game;

    public FriendClick(Window gameWindow, JButton penguin, MainGame game) {
        this.gameWindow = gameWindow;
        this.penguin=penguin;
        this.game=game;
    }

    public void actionPerformed(ActionEvent e)
    {
        game.isWithFriend=true;
        try
        {
            gameWindow.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("./res/Cartoon_Forest_BG_02.png")))));     //Zmiana tła
        }
        catch(Exception m)
        {
            System.out.println("Błąd pliku backgroung");
        }

        gameWindow.ButtonImage(penguin,"./res/veryHappy2.png",350,310,false);
        gameWindow.ButtonImage(panda,"./res/HappyPanda2.png",650,310,false);    //Dodanie guzika pandy

        gameWindow.ButtonImage(leave,"./res/Lave.png",0,0,true);
        leave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {        //Po naciśnięciu guzika leave panda znika i gra wraca do orgyginalnego widoku

                game.isWithFriend=false;
                gameWindow.ButtonImage(penguin,"./res/Pengiun2.png",280,285,false);

                try
                {
                    gameWindow.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("./res/snowy01_preview-01.png")))));
                }
                catch(Exception m)
                {
                    System.out.println("Błąd pliku backgroung");
                }

                gameWindow.remove(panda);
                gameWindow.remove(leave);

                gameWindow.add(game.food);
                gameWindow.add(game.sleep);
                gameWindow.add(game.friend);
                gameWindow.add(penguin);
                gameWindow.add(game.healthPoints);
                gameWindow.add(game.happyPoints);
                gameWindow.setVisible(true);
            }
        });

        JPanel info = new JPanel();
        info.setBounds(600, 150, 800, 500);
        info.setOpaque(false);

        JTextArea friendInfo = new JTextArea();
        friendInfo.setText(Subtitles.friendInfo);
        friendInfo.setForeground(Color.white);
        friendInfo.setOpaque(false);
        friendInfo.setVisible(true);

        game.happy+=500;
        game.happyPoints.setText("Mood: "+ String.valueOf(game.happy));
        info.add(friendInfo);

        Font font = friendInfo.getFont();
        float size = font.getSize() + 13.0f;
        friendInfo.setFont( font.deriveFont(size) );

        panda.addActionListener(new PandaClick(gameWindow));

        gameWindow.add(penguin);
        gameWindow.add(panda);
        gameWindow.add(game.happyPoints);
        gameWindow.add(game.healthPoints);
        gameWindow.add(leave);
        gameWindow.add(info);

        gameWindow.setVisible(true);
    }
}
