package org.example.views;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.gui2.*;
import org.example.controllers.QuizController;

public class QuizView {
    private QuizController quizController;
    private MultiWindowTextGUI Gui;

    public QuizView(QuizController quizController, MultiWindowTextGUI Gui){
        this.quizController = quizController;
        this.Gui = Gui;
    }
    public void ShowQuiz() {
        Gui.removeWindow(Gui.getActiveWindow());
        BasicWindow menuWindow = new BasicWindow();
        Panel panel = new Panel();
        panel.setPreferredSize(new TerminalSize(85, 25));

        String drawnKey = quizController.getDrawnKeyNotFamiliarizedQuiz();
        Label key = new Label("Podaj tłumaczenie angielskie słowa: ");
        key.addStyle(SGR.BOLD);
        key.setPreferredSize(new TerminalSize(85, 1));
        panel.addComponent(key);

        Label keyy = new Label(drawnKey);
        keyy.addStyle(SGR.BOLD);
        keyy.setForegroundColor(TextColor.ANSI.YELLOW);
        keyy.setPreferredSize(new TerminalSize(85, 1));
        panel.addComponent(keyy);

        var value = new TextBox().addTo(panel);

        Button buttonFirst = new Button("Następne słowo", new Runnable() {
            @Override
            public void run() {
                quizController.removeField(drawnKey);
                quizController.checkAnswer(drawnKey, value.getText());
            }
        });
        panel.addComponent(buttonFirst);

        menuWindow.setComponent(panel);
        Gui.addWindowAndWait(menuWindow);
    }
}
