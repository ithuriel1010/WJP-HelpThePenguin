package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;

import static javax.print.attribute.standard.MediaSize.JIS.B1;



public class Main {


    public static JTextArea instruction;
    public static JButton goToTheGame;

    public static void main(String[] args) {

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();
        System.out.println(width);
        System.out.println(height);

        Main m = new Main();

        Window game = new Window("Help the Penguin",width, height, width/2, height/2 );

        try
        {
            game.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("./snowy01_preview-01.png")))));
        }
        catch(Exception e)
        {
            System.out.println("Błąd pliku backgroung");
        }



        instruction = new JTextArea();
        goToTheGame = new JButton();
        instruction.setText(game.GetFromFile("./Rozpocznij.txt"));
        //instruction.setText("Aby grać w grą należy opiekować się pingwinkiem! \nTrzeba pamiętać o spaniu, karmieniu i spotkaniach z przyjaciółmi \n");
        instruction.setOpaque(false);
        instruction.setBounds(100,100,600,300);
        //goToTheGame.setText("Przejdź do gry!");
        instruction.setVisible(true);
        goToTheGame.setVisible(true);

        goToTheGame.addActionListener(new MainGame(game,instruction,goToTheGame));
        game.ButtonImage(goToTheGame, "./Rozpocznij.png",100,500,true);

        game.add(instruction);
        game.add(goToTheGame);
        game.setVisible(true);
    }

}

