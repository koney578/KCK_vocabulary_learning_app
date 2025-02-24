package org.example.viewsGraphics;

import org.example.controllersGraphics.GStudyController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GStudyView {
    private JFrame jframe;
    private GStudyController gStudyController;

    public GStudyView(GStudyController gStudyController, JFrame jframe) {
        this.gStudyController = gStudyController;
        this.jframe = jframe;
    }

    public void ShowStudy() {
        jframe.getContentPane().removeAll();
        jframe.getContentPane().revalidate();
        jframe.getContentPane().repaint();

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(12,1));
        jframe.getContentPane().add(mainPanel);

        JLabel label1 = new JLabel("ZAZNAJOMIONO: " + gStudyController.howManyFamiliarized() + " / " + gStudyController.getSizeData());
        label1.setFont(new Font("Arial", Font.ITALIC, 24));
        label1.setForeground(Color.BLUE);
        mainPanel.add(label1);

        JLabel label2 = new JLabel("");
        label2.setFont(new Font("Arial", Font.ITALIC, 24));
        mainPanel.add(label2);

        JLabel label3 = new JLabel("SŁOWO POLSKIE: ");
        label3.setFont(new Font("Arial", Font.ITALIC, 24));
        mainPanel.add(label3);

        String drawnKey = gStudyController.getDrawnKeyNotFamiliarized();
        JLabel label4 = new JLabel(drawnKey);
        label4.setFont(new Font("Arial", Font.ITALIC, 24));
        label4.setForeground(Color.GREEN);
        mainPanel.add(label4);

        JLabel label5 = new JLabel("TŁUMACZENIE ANGIELSKIE: ");
        label5.setFont(new Font("Arial", Font.ITALIC, 24));
        mainPanel.add(label5);

        JLabel label6 = new JLabel("********");
        label6.setFont(new Font("Arial", Font.ITALIC, 24));
        label6.setForeground(Color.PINK);
        mainPanel.add(label6);

        JLabel label7 = new JLabel("");
        label7.setFont(new Font("Arial", Font.ITALIC, 24));
        mainPanel.add(label7);

        JButton firstButton = new JButton("Odkryj tłumaczenie");
        firstButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label6.setText(gStudyController.getDrawnValue(drawnKey));
            }
        });
        firstButton.setBackground(Color.PINK);
        mainPanel.add(firstButton);

        JButton secondButton = new JButton("Następne słowo");
        secondButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gStudyController.removeField(drawnKey);
            }
        });
        secondButton.setBackground(Color.PINK);
        mainPanel.add(secondButton);

        JButton thirdButton = new JButton("Powrót");
        thirdButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gStudyController.getNewMenuView();
            }
        });
        thirdButton.setBackground(Color.PINK);
        mainPanel.add(thirdButton);

        JButton fourthButton = new JButton("Wyzeruj statystyki");
        fourthButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gStudyController.resetData();
                gStudyController.run();
            }
        });
        fourthButton.setBackground(Color.PINK);
        mainPanel.add(fourthButton);

        jframe.setVisible(true);
    }
}
