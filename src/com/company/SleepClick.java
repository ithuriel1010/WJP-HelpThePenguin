package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SleepClick implements ActionListener {
    public Window gameWindow;
    public JButton penguin2;
    public JTextArea healthInfo;
    public JPanel sleepTime;
    private MainGame game;

    public SleepClick(Window gameWindow, JButton penguin, MainGame game) {
        this.gameWindow = gameWindow;
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

        if(game.foodMenuOpen==false)       //Sprawdzenie czy okno jedzenia nie jest otwarte i jego ewentualne zamykanie
        {
            CreateSleepPanel();
            game.sleepMenuOpen=true;
        }
        else if(game.foodMenuOpen==true)
        {
            game.foodClick.ZakonczKarmienie();
            CreateSleepPanel();
            game.sleepMenuOpen=true;
        }

    }

    public void CreateSleepPanel()              //Tworzenie panelu snu
    {
        sleepTime = new TransparentPanel();
        sleepTime.setBounds(0, 0, 500, 300);
        sleepTime.setOpaque(false);
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
                gameWindow.ButtonImage(penguin2, "./res/SleepingPenguin2.png", 280, 285, false);

                try {
                    iloscSnui = Integer.parseInt(iloscSnu);

                    if (iloscSnui < 8) {                //Sprawdzana jest wartośc snu i w jakich zakresach się ona mieści - odpowiednia informacja zostaje wtedy wyświetlona
                        sleepinfo.setText(Subtitles.tooLittleSleep);
                        game.happy-=100;
                        game.health -=100;
                        NotEnoughSleep();

                    } else if (iloscSnui >= 8 && iloscSnui <= 10) {
                        sleepinfo.setText(Subtitles.enoughSleep);
                        game.happy+=100;
                        game.health +=100;
                    } else if (iloscSnui > 10) {
                        sleepinfo.setText(Subtitles.tooMuchSleep);
                        game.happy-=100;
                        game.health -=100;
                    } else {
                        sleepinfo.setText(Subtitles.incorrectValue);
                    }
                    sleepinfo.setVisible(true);
                } catch (Exception v) {
                    sleepinfo.setText("Wpisz poprawną wartość");
                }

                game.healthPoints.setText("Health: "+ game.health);
                game.happyPoints.setText("Mood: "+ game.happy);

                gameWindow.add(game.healthPoints);
                gameWindow.add(game.happyPoints);

                allSleepInfo.setText(Subtitles.sleepInfo2);
                allSleepInfo.setVisible(true);
                allSleepInfo.setLocation(10, 200);

                rozumiem.setVisible(true);
            }
        });


        rozumiem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ZakonczSpanie();
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

        gameWindow.add(sleepTime);
        gameWindow.setVisible(true);
    }

    public void ZakonczSpanie()             //Metoda zamykająca panel snu
    {
        game.sleepMenuOpen=false;
        sleepTime.setVisible(false);
        gameWindow.ButtonImage(penguin2, "./res/Pengiun2.png", 280, 285, false);
        gameWindow.remove(sleepTime);
    }

    private void NotEnoughSleep()            //Metoda wyświetlająca informacje o niedoborze snu
    {
        healthInfo.setText(Subtitles.notEnoughSleepInfo);
        healthInfo.setVisible(true);
        gameWindow.setVisible(true);
    }
}
