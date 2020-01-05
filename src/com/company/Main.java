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

        Window gameWindow = new Window("Help the Penguin",width, height, width/2, height/2 );     //Tworzenie okna gry

        try
        {
            gameWindow.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("./res/snowy01_preview-01.png")))));       //Ustawienie tła
        }
        catch(Exception e)
        {
            System.out.println("Błąd pliku backgroung");
        }

        instruction = new JTextArea();
        goToTheGame = new JButton();

        instruction.setText(Subtitles.firstInstruction);
        instruction.setEditable(false);
        Font font = instruction.getFont();
        float size = font.getSize() + 20.0f;
        instruction.setFont( font.deriveFont(size) );
        instruction.setForeground(Color.white);
        instruction.setOpaque(false);
        instruction.setBounds(20,80,1500,500);
        instruction.setVisible(true);
        goToTheGame.setVisible(true);

        goToTheGame.addActionListener(new MainGame(gameWindow,instruction,goToTheGame));
        gameWindow.ButtonImage(goToTheGame, "./res/Rozpocznij.png",100,550,true);

        gameWindow.add(instruction);
        gameWindow.add(goToTheGame);
        gameWindow.setVisible(true);
    }

}

