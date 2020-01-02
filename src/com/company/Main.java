package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;

import static javax.print.attribute.standard.MediaSize.JIS.B1;



public class Main {

    public static void main(String[] args) {

        JTextArea instruction;
        JButton goToTheGame;
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
        //instruction.setText(game.GetFromFile("./Rozpocznij.txt"));
        //instruction.setText("Witaj w grze 'Help the Penguin'! \nZasady gry nie są trudne: Musisz opiekować się pingwinkiem co nauczy cię troche \no zdrowiu psychicznym i co zrobić aby było ono jak najlepsze. \nPingwina możesz karmić, kłaść spać oraz wysyłać go na spotkania z przyjaciółmi. \nPamiętaj jednak że jedzenie i sen powinny być w zdrowej ilości! Monitoruj nastrój oraz zdrowie \npingwinka! Wzrastają one kiedy zrobisz coś dobrze i spadają kiedy twoja decyzja nie była najzdrowsza! \nGrając zobaczysz informacje o zdrowiu i o tym jak o nie dbać, pamiętaj jednak że to tylko gra! \nJeśli masz problem lub źle się czujesz porozmawiaj z kimś dorosłym! \nPóki co jednak życzę ci wspaniałej gry z pingwinkiem!!!");

        instruction.setText(Subtitles.firstInstruction);
        Font font = instruction.getFont();
        float size = font.getSize() + 20.0f;
        instruction.setFont( font.deriveFont(size) );
        instruction.setForeground(Color.white);
        instruction.setOpaque(false);
        instruction.setBounds(70,100,1500,500);
        //goToTheGame.setText("Przejdź do gry!");
        instruction.setVisible(true);
        goToTheGame.setVisible(true);

        goToTheGame.addActionListener(new MainGame(game,instruction,goToTheGame));
        game.ButtonImage(goToTheGame, "./Rozpocznij.png",100,550,true);

        game.add(instruction);
        game.add(goToTheGame);
        game.setVisible(true);
    }

}

