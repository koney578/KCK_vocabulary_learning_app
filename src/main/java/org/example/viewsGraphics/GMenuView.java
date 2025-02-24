package org.example.viewsGraphics;

import org.example.controllersGraphics.GMenuController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class GMenuView {
    private JFrame jframe;
    private GMenuController gMenuController;

    public GMenuView(GMenuController gMenuController, JFrame jframe) {
        this.gMenuController = gMenuController;
        this.jframe = jframe;
    }

    public void ShowMenu() {
        jframe.getContentPane().removeAll();
        jframe.getContentPane().revalidate();
        jframe.getContentPane().repaint();

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(8,1));
        jframe.getContentPane().add(mainPanel);

        JLabel label1 = new JLabel("Witaj w aplikacji do nauki słówek!");
        label1.setFont(new Font("Arial", Font.ITALIC, 24));
        mainPanel.add(label1);

        JLabel label2 = new JLabel("Co chcesz zrobić?");
        label2.setFont(new Font("Arial", Font.ITALIC, 24));
        mainPanel.add(label2);

        JButton firstButton = new JButton("Chcę się uczyć! (Fiszki)");
        firstButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gMenuController.getNewStudyView();
            }
        });
        firstButton.setBackground(Color.PINK);
        mainPanel.add(firstButton);

        JButton secondButton = new JButton("Chcę dodać nowe słowo do słownika!");
        secondButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gMenuController.getNewAddWordView();
            }
        });
        secondButton.setBackground(Color.PINK);
        mainPanel.add(secondButton);

        JButton thirdButton = new JButton("Chcę usunąć słowo ze słownika!");
        thirdButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gMenuController.getNewRemoveWordView();
            }
        });
        thirdButton.setBackground(Color.PINK);
        mainPanel.add(thirdButton);

        JButton fourthButton = new JButton("Chcę sprawdzić swoją wiedzę! (Test - 5 słów)");
        fourthButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gMenuController.getNewTestView();
            }
        });
        fourthButton.setBackground(Color.PINK);
        mainPanel.add(fourthButton);

        JButton fifthButton = new JButton("Nie chcę już się uczyć! (Wyjście))");
        fifthButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gMenuController.exitApp();
            }
        });
        fifthButton.setBackground(Color.PINK);
        mainPanel.add(fifthButton);

        JButton sixthButton = new JButton("Chcę przełączyć się na tryb tekstowy");
        sixthButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    gMenuController.runText();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        sixthButton.setBackground(Color.PINK);
        mainPanel.add(sixthButton);

        jframe.setVisible(true);
    }
}
