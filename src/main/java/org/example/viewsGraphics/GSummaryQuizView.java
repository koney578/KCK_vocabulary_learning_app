package org.example.viewsGraphics;
import org.example.controllersGraphics.GSummaryQuizController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class GSummaryQuizView {
    private JFrame jframe;
    private GSummaryQuizController gSummaryQuizController;

    public GSummaryQuizView(GSummaryQuizController gSummaryQuizController, JFrame jframe) {
        this.gSummaryQuizController = gSummaryQuizController;
        this.jframe = jframe;
    }

    public void ShowQuizView(int points) {
        jframe.getContentPane().removeAll();
        jframe.getContentPane().revalidate();
        jframe.getContentPane().repaint();

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(12,1));
        jframe.getContentPane().add(mainPanel);

        JLabel label1 = new JLabel("Udzieliłeś "+points+" poprawnych odpowiedzi na 5 pytań");
        label1.setFont(new Font("Arial", Font.ITALIC, 24));
        label1.setForeground(Color.MAGENTA);
        Timer timer = new Timer(500, e -> label1.setVisible(!label1.isVisible()));
        timer.start();
        mainPanel.add(label1);

        JLabel label3 = new JLabel("");
        label1.setFont(new Font("Arial", Font.ITALIC, 24));
        mainPanel.add(label3);

        JLabel label2 = new JLabel("Słowo        Poprawne tłumaczenie        Twoje tłumaczenie");
        label2.setFont(new Font("Arial", Font.ITALIC, 24));
        label2.setForeground(Color.PINK);
        mainPanel.add(label2);

        List<String> summary = gSummaryQuizController.getSummarry();
        String line1 = summary.get(0);
        String line2 = summary.get(1);
        String line3 = summary.get(2);
        String line4 = summary.get(3);
        String line5 = summary.get(4);

        JLabel label4 = new JLabel(line1);
        label4.setFont(new Font("Arial", Font.ITALIC, 24));
        mainPanel.add(label4);

        JLabel label5 = new JLabel(line2);
        label5.setFont(new Font("Arial", Font.ITALIC, 24));
        mainPanel.add(label5);

        JLabel label6 = new JLabel(line3);
        label6.setFont(new Font("Arial", Font.ITALIC, 24));
        mainPanel.add(label6);

        JLabel label7 = new JLabel(line4);
        label7.setFont(new Font("Arial", Font.ITALIC, 24));
        mainPanel.add(label7);

        JLabel label8 = new JLabel(line5);
        label8.setFont(new Font("Arial", Font.ITALIC, 24));
        mainPanel.add(label8);

        JLabel label9 = new JLabel("");
        label9.setFont(new Font("Arial", Font.ITALIC, 24));
        mainPanel.add(label9);

        JButton firstButton = new JButton("Powrót");
        firstButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gSummaryQuizController.resetSummary();
                gSummaryQuizController.resetDataQuiz();
                gSummaryQuizController.getNewMenuView();
            }
        });
        firstButton.setBackground(Color.PINK);
        mainPanel.add(firstButton);
        jframe.setVisible(true);
    }
}
