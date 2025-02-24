package org.example.viewsGraphics;

import org.example.controllersGraphics.GRemoveWordController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GRemoveWordView {
    private JFrame jframe;
    private GRemoveWordController gRemoveWordController;

    public GRemoveWordView(GRemoveWordController gRemoveWordController, JFrame jframe) {
        this.gRemoveWordController = gRemoveWordController;
        this.jframe = jframe;
    }

    public void ShowRemoveWordView() {
        jframe.getContentPane().removeAll();
        jframe.getContentPane().revalidate();
        jframe.getContentPane().repaint();

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(12,1));
        jframe.getContentPane().add(mainPanel);

        JLabel label1 = new JLabel("Aby usunąć fiszkę uzupełnij poniższe pole: ");
        label1.setFont(new Font("Arial", Font.ITALIC, 24));
        mainPanel.add(label1);

        JLabel label3 = new JLabel("");
        label3.setFont(new Font("Arial", Font.ITALIC, 24));
        mainPanel.add(label3);

        JLabel label2 = new JLabel("Słowo polskie:");
        label2.setFont(new Font("Arial", Font.ITALIC, 24));
        mainPanel.add(label2);

        JTextField textField = new JTextField("Tu wpisz polskie słowo...");
        mainPanel.add(textField);

        JLabel label4 = new JLabel("");
        label4.setFont(new Font("Arial", Font.ITALIC, 24));
        mainPanel.add(label4);

        JButton firstButton = new JButton("Potwierdź usunięcie słowa");
        firstButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gRemoveWordController.removeWord(textField.getText());
                gRemoveWordController.run();
            }
        });
        firstButton.setBackground(Color.PINK);
        mainPanel.add(firstButton);

        JButton secondButton = new JButton("Powrót");
        secondButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gRemoveWordController.getNewMenuView();
            }
        });
        secondButton.setBackground(Color.PINK);
        mainPanel.add(secondButton);

        jframe.setVisible(true);
    }
}
