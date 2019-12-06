package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;


public class sleepClick implements ActionListener {
    public Window g;
    public Window w;
    public JButton penguin2;
    public int width2;
    public int height2;


    public sleepClick(Window gameWindow, JButton penguin) {
        g = gameWindow;
        w = new Window();
        penguin2 = penguin;
    }

    public void actionPerformed(ActionEvent e) {
        JButton b = (JButton) e.getSource();

        JPanel sleepTime = new JPanel();
        sleepTime.setBounds(0, 0, 500, 250);
        sleepTime.setOpaque(true);
        //sleepTime.setLocation(new Point(500,200));
        sleepTime.setBackground(Color.PINK);

        JTextArea info = new JTextArea();
        info.setOpaque(false);
        //info.setContentAreaFilled(false);
        //b.setBorderPainted(false);
        info.setText("Wpisz ile czau ma spać Huggsy:");
        info.setEditable(false);
        info.setBounds(550, 325, 400, 100);

        JTextField time = new JTextField("np. 8", 10);
        time.setOpaque(false);

        JTextArea sleepinfo = new JTextArea();
        sleepinfo.setEditable(false);
        sleepinfo.setOpaque(false);
        sleepinfo.setLocation(540, 50);

        JTextArea allSleepInfo = new JTextArea();
        allSleepInfo.setEditable(false);
        allSleepInfo.setOpaque(false);

        JButton rozumiem = new JButton();
        rozumiem.setText("Rozumiem");
        rozumiem.setVisible(false);

        JButton zatwerdzSen = new JButton();
        zatwerdzSen.setText("Zatwierdz");
        zatwerdzSen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String iloscSnu = time.getText();
                int iloscSnui;
                w.ButtonImage(penguin2, "D:/Studia/Semestr V/Współczesne języki programowania/Projekt/Penguin/SleepingPenguin.png", 500, 275, false);


                try {
                    iloscSnui = Integer.parseInt(iloscSnu);


                    if (iloscSnui < 8) {
                        sleepinfo.setText("Jest to troche za mało snu");
                    } else if (iloscSnui >= 8 && iloscSnui <= 10) {
                        sleepinfo.setText("To jest odpowiednia ilość snu!");
                    } else if (iloscSnui > 10) {
                        sleepinfo.setText("Jest to troche za dużo snu");
                    } else {
                        sleepinfo.setText("Wpisz poprawną ilośc snu!");
                    }
                    sleepinfo.setVisible(true);
                } catch (Exception v) {
                    sleepinfo.setText("Wpisz poprawną wartość");
                }

                allSleepInfo.setText("Nastolatki (14-17 lat) powinny spać 8-10 godzin. \nMłodzież (18-25 lat) powinna spać 7-9 godzin. \nDorośli w wieku 26-64 lat powinni spać 7-9 godzin. \nDorośli w wieku 65 lat i więcej powinni spać 7-8 godzin na dobę");
                allSleepInfo.setVisible(true);
                allSleepInfo.setLocation(10, 200);
                rozumiem.setVisible(true);
            }
        });


        rozumiem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sleepTime.setVisible(false);
                //allSleepInfo.setVisible(false);
                w.ButtonImage(penguin2, "D:/Studia/Semestr V/Współczesne języki programowania/Projekt/Penguin/HappyPenguin.png", 500, 275, false);
                g.remove(sleepTime);
            }
        });

        sleepTime.add(info);
        sleepTime.add(time);
        sleepTime.add(zatwerdzSen);
        sleepTime.add(sleepinfo);
        sleepTime.add(allSleepInfo);
        sleepTime.add(rozumiem);
        sleepTime.setVisible(true);

        g.add(sleepTime);
        g.setVisible(true);
    }
}
