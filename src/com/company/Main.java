package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

class ImagePanel extends JComponent {
    private Image image;
    public ImagePanel(Image image) {
        this.image = image;
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }
}

public class Main {

    public static void main(String[] args) {

        BufferedImage bimg;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();
        Window game = new Window("Help the Penguin",width, height, width/2, height/2 );

        try
        {
            game.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("D:/Studia/Semestr V/Współczesne języki programowania/Projekt/Background/Snowy/01/snowy01_preview-01.png")))));
        }
        catch(Exception e)
        {
            System.out.println("Błąd pliku backgroung");
        }


        JPanel mainPanel = new JPanel();
        mainPanel.setVisible(true);

        JButton food = new JButton();

        try
        {
            //Image img = ImageIO.read(new File("C:/Users/Ola/Desktop/pizza.jpg"));
            bimg = ImageIO.read(new File("D:/Studia/Semestr V/Współczesne języki programowania/Projekt/Penguin/happy_penguin.png"));
            int imagewidth = bimg.getWidth();
            int imageheight= bimg.getHeight();
            //food.setBackground(Color.black);
            food.setSize(imagewidth,imageheight);
            food.setIcon(new ImageIcon(bimg));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        food.setOpaque(false);
        food.setContentAreaFilled(false);
        food.setBorderPainted(false);

        //food.setIcon(new ImageIcon(Class.class.getResource("C:/Users/Ola/Desktop/pizza.jpg")));

        //game.add(mainPanel,BorderLayout.CENTER);
        game.setVisible(true);

        game.add(food, BorderLayout.CENTER);
        game.setVisible(true);
        food.setVisible(true);


    }
}
