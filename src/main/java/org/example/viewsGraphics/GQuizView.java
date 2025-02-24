package org.example.viewsGraphics;

import org.example.controllersGraphics.GQuizController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GQuizView {
    private JFrame jframe;
    private GQuizController gQuizController;
    public GQuizView(GQuizController gQuizController, JFrame jframe) {
        this.gQuizController = gQuizController;
        this.jframe = jframe;
    }
    public void ShowQuiz() {
        jframe.getContentPane().removeAll();
        jframe.getContentPane().revalidate();
        jframe.getContentPane().repaint();

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(12,1));
        jframe.getContentPane().add(mainPanel);

        JLabel label1 = new JLabel("Podaj tłumaczenie angielskie słowa: ");
        label1.setFont(new Font("Arial", Font.ITALIC, 24));
        mainPanel.add(label1);

        JLabel label3 = new JLabel("");
        label3.setFont(new Font("Arial", Font.ITALIC, 24));
        mainPanel.add(label3);

        String drawnKey = gQuizController.getDrawnKeyNotFamiliarizedQuiz();

        JLabel label2 = new JLabel(drawnKey);
        label2.setFont(new Font("Arial", Font.ITALIC, 24));
        label2.setForeground(Color.BLUE);
        mainPanel.add(label2);

        JTextField textField = new JTextField();
        mainPanel.add(textField);

        JLabel label4 = new JLabel("");
        label4.setFont(new Font("Arial", Font.ITALIC, 24));
        mainPanel.add(label4);

        JButton firstButton = new JButton("Następne słowo");
        firstButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gQuizController.removeField(drawnKey);
                gQuizController.checkAnswer(drawnKey, textField.getText());
            }
        });
        firstButton.setBackground(Color.PINK);
        mainPanel.add(firstButton);

        jframe.setVisible(true);
    }
}
