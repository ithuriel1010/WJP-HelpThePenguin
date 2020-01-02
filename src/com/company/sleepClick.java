package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;


public class sleepClick implements ActionListener {
    public Window g;
    public Window w;
    public JButton penguin2;
    public JTextArea healthInfo;
    private MainGame game;


    public sleepClick(Window gameWindow, JButton penguin,MainGame game) {
        g = gameWindow;
        w = new Window();
        penguin2 = penguin;
        this.game=game;
    }

    private class TransparentPanel extends JPanel {
        {
            setOpaque(false);
        }
        public void paintComponent(Graphics g) {
            g.setColor(getBackground());
            Rectangle r = g.getClipBounds();
            g.fillRect(r.x, r.y, r.width, r.height);
            super.paintComponent(g);
        }
    }

    public void actionPerformed(ActionEvent e) {
        JButton b = (JButton) e.getSource();

        JPanel sleepTime = new TransparentPanel();
        sleepTime.setBounds(0, 0, 500, 300);
        sleepTime.setOpaque(false);
        //sleepTime.setLocation(new Point(500,200));
        sleepTime.setBackground(new Color(211,211,211,125));

        JTextArea info = new JTextArea();
        info.setOpaque(false);
        info.setText(Subtitles.sleepInfo1);
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

        healthInfo = new JTextArea();
        healthInfo.setEditable(false);
        healthInfo.setOpaque(false);

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
                w.ButtonImage(penguin2, "./SleepingPenguin2.png", 500, 275, false);


                try {
                    iloscSnui = Integer.parseInt(iloscSnu);


                    if (iloscSnui < 8) {
                        sleepinfo.setText(Subtitles.tooLittleSleep);
                        MainGame.happy-=100;
                        game.hungry-=100;
                        NotEnoughSleep();
//                        healthInfo.setVisible(true);
//                        sleepTime.add(healthInfo);

                    } else if (iloscSnui >= 8 && iloscSnui <= 10) {
                        sleepinfo.setText(Subtitles.enoughSleep);
                        MainGame.happy+=100;
                        game.hungry+=100;
                    } else if (iloscSnui > 10) {
                        sleepinfo.setText(Subtitles.tooMuchSleep);
                        MainGame.happy-=100;
                        game.hungry-=100;
                    } else {
                        sleepinfo.setText(Subtitles.incorrectValue);
                    }
                    sleepinfo.setVisible(true);
                } catch (Exception v) {
                    sleepinfo.setText("Wpisz poprawną wartość");
                }

                MainGame.hungryPoints.setText("Health: "+ String.valueOf(game.hungry));
                MainGame.happyPoints.setText("Mood: "+ String.valueOf(MainGame.happy));

                g.add(MainGame.hungryPoints);
                g.add(MainGame.happyPoints);

                allSleepInfo.setText(Subtitles.sleepInfo2);
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
                w.ButtonImage(penguin2, "./Pengiun2.png", 500, 275, false);
                g.remove(sleepTime);
            }
        });



        sleepTime.add(info);
        sleepTime.add(time);
        sleepTime.add(zatwerdzSen);
        sleepTime.add(sleepinfo);
        sleepTime.add(allSleepInfo);
        sleepTime.add(rozumiem);
        sleepTime.add(healthInfo);
        sleepTime.setVisible(true);

        g.add(sleepTime);
        g.setVisible(true);
    }

    public void NotEnoughSleep()
    {
        healthInfo.setText(Subtitles.notEnoughSleepInfo);
        healthInfo.setVisible(true);
        g.setVisible(true);

    }
}
