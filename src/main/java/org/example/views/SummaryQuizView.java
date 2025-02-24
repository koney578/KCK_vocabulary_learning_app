package org.example.views;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.gui2.*;
import org.example.controllers.SummaryQuizController;

import java.io.IOException;

public class SummaryQuizView {
    private SummaryQuizController summaryQuizController;
    private MultiWindowTextGUI Gui;
    public SummaryQuizView(SummaryQuizController summaryQuizController, MultiWindowTextGUI Gui) {
        this.summaryQuizController = summaryQuizController;
        this.Gui = Gui;
    }

    public void ShowQuizView(int points){
        Gui.removeWindow(Gui.getActiveWindow());
        BasicWindow menuWindow = new BasicWindow();
        Panel panel = new Panel();
        panel.setPreferredSize(new TerminalSize(85, 25));

        Label information = new Label("Udzieliłeś "+points+" poprawnych odpowiedzi na 5 pytań");
        information.addStyle(SGR.ITALIC);
        information.addStyle(SGR.BOLD);
        information.setForegroundColor(TextColor.ANSI.CYAN);
        information.setPreferredSize(new TerminalSize(85, 2));
        panel.addComponent(information);

        Label message = new Label(("Słowo        Poprawne tłumaczenie        Twoje tłumaczenie"));
        message.addStyle(SGR.BOLD);
        message.setForegroundColor(TextColor.ANSI.MAGENTA);
        message.setPreferredSize(new TerminalSize(85, 1));
        panel.addComponent(message);

        Label summary = new Label(summaryQuizController.getSummarry());
        summary.addStyle(SGR.BOLD);
        summary.setPreferredSize(new TerminalSize(85, 6));
        panel.addComponent(summary);

        Button buttonFirst = new Button("Powrót", new Runnable() {
            @Override
            public void run() {
                summaryQuizController.resetSummary();
                summaryQuizController.resetDataQuiz();
                try {
                    summaryQuizController.getNewMenuView();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        panel.addComponent(buttonFirst);
        menuWindow.setComponent(panel);
        Gui.addWindowAndWait(menuWindow);
    }
}
