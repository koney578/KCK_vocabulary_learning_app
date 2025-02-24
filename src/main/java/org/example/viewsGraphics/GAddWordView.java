package org.example.viewsGraphics;
import org.example.controllersGraphics.GAddWordController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GAddWordView {
    private JFrame jframe;
    private GAddWordController gAddWordController;

    public GAddWordView(GAddWordController gAddWordController, JFrame jframe) {
        this.gAddWordController = gAddWordController;
        this.jframe = jframe;
    }

    public void ShowAddWordView() {
        jframe.getContentPane().removeAll();
        jframe.getContentPane().revalidate();
        jframe.getContentPane().repaint();

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(12,1));
        jframe.getContentPane().add(mainPanel);

        JLabel label1 = new JLabel("Aby dodać nową fiszkę uzupełnij poniższe pola: ");
        label1.setFont(new Font("Arial", Font.ITALIC, 24));
        mainPanel.add(label1);

        JLabel label4 = new JLabel("");
        label4.setFont(new Font("Arial", Font.ITALIC, 24));
        mainPanel.add(label4);

        JLabel label2 = new JLabel("Słowo polskie:");
        label2.setFont(new Font("Arial", Font.ITALIC, 24));
        mainPanel.add(label2);

        JTextField textField = new JTextField("Tu wpisz polskie słowo...");
        mainPanel.add(textField);

        JLabel label3 = new JLabel("Tłumaczenie angielskie:");
        label3.setFont(new Font("Arial", Font.ITALIC, 24));
        mainPanel.add(label3);

        JTextField textField2 = new JTextField("Tu wpisz angielskie tłumaczenie...");
        mainPanel.add(textField2);

        JLabel label6 = new JLabel("");
        label6.setFont(new Font("Arial", Font.ITALIC, 24));
        mainPanel.add(label6);

        JButton firstButton = new JButton("Potwierdź dodanie słowa");
        firstButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gAddWordController.addWord(textField.getText(), textField2.getText());
                gAddWordController.run();
            }
        });
        firstButton.setBackground(Color.PINK);
        mainPanel.add(firstButton);

        JButton secondButton = new JButton("Powrót");
        secondButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gAddWordController.getNewMenuView();
            }
        });
        secondButton.setBackground(Color.PINK);
        mainPanel.add(secondButton);

        jframe.setVisible(true);
    }
}
