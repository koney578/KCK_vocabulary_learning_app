package org.example.viewsGraphics;

import org.example.controllersGraphics.GSummaryController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GSummaryView {
    private JFrame jframe;
    private GSummaryController gSummaryController;

    public GSummaryView(GSummaryController gSummaryController, JFrame jframe) {
        this.gSummaryController = gSummaryController;
        this.jframe = jframe;
    }

    public void ShowSumarry() {
        jframe.getContentPane().removeAll();
        jframe.getContentPane().revalidate();
        jframe.getContentPane().repaint();

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(12,1));
        jframe.getContentPane().add(mainPanel);

        JLabel label1 = new JLabel("Gratulacje!");
        label1.setFont(new Font("Arial", Font.ITALIC, 24));
        label1.setForeground(Color.GREEN);
        mainPanel.add(label1);

        JLabel label2 = new JLabel("Zaznajomiono wszystkie "+ gSummaryController.sizeData()+" słów.");
        label2.setFont(new Font("Arial", Font.ITALIC, 24));
        label2.setForeground(Color.BLUE);
        mainPanel.add(label2);
        Timer timer = new Timer(500, e -> label2.setVisible(!label2.isVisible()));
        timer.start();

        JLabel label3 = new JLabel("");
        label3.setFont(new Font("Arial", Font.ITALIC, 24));
        mainPanel.add(label3);

        JButton firstButton = new JButton("Zresetuj postępy i zacznij od nowa!");
        firstButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gSummaryController.resetData();
                gSummaryController.getNewStudyView();
            }
        });
        firstButton.setBackground(Color.PINK);
        mainPanel.add(firstButton);

        JButton secondButton = new JButton("Powrót");
        secondButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gSummaryController.getNewMenuView();
            }
        });
        secondButton.setBackground(Color.PINK);
        mainPanel.add(secondButton);

        jframe.setVisible(true);
    }
}
