package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;

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

        instruction.setText(Subtitles.firstInstruction);
        Font font = instruction.getFont();
        float size = font.getSize() + 20.0f;
        instruction.setFont( font.deriveFont(size) );
        instruction.setForeground(Color.white);
        instruction.setOpaque(false);
        instruction.setBounds(70,100,1500,500);
        instruction.setVisible(true);
        goToTheGame.setVisible(true);

        goToTheGame.addActionListener(new MainGame(game,instruction,goToTheGame));
        game.ButtonImage(goToTheGame, "./Rozpocznij.png",100,550,true);

        game.add(instruction);
        game.add(goToTheGame);
        game.setVisible(true);
    }

}

