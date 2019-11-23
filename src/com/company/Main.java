package com.company;

import java.awt.*;

public class Main {

    public static void main(String[] args) {

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();
        Window game = new Window("Help the Penguin",width, height, width/2, height/2 );
        game.setVisible(true);

    }
}
