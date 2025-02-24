package org.example.views;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.gui2.*;
import org.example.controllers.StudyController;

import java.io.IOException;

public class StudyView {
    private StudyController studyController;
    private MultiWindowTextGUI Gui;
    public StudyView(StudyController studyController, MultiWindowTextGUI Gui){
        this.studyController = studyController;
        this.Gui = Gui;
    }
    public void ShowStudy() {
        Gui.removeWindow(Gui.getActiveWindow());
        BasicWindow menuWindow = new BasicWindow();
        Panel panel = new Panel();
        panel.setPreferredSize(new TerminalSize(85, 25));

        Label information = new Label("ZAZNAJOMIONO: " + studyController.howManyFamiliarized() + " / " + studyController.getSizeData());
        information.addStyle(SGR.ITALIC);
        information.addStyle(SGR.BOLD);
        information.setForegroundColor(TextColor.ANSI.BLUE);
        information.setPreferredSize(new TerminalSize(85, 1));
        panel.addComponent(information);

        Label line1 = new Label("");
        line1.setPreferredSize(new TerminalSize(85, 1));
        panel.addComponent(line1);

        String drawnKey = studyController.getDrawnKeyNotFamiliarized();
        Label key = new Label("SŁOWO POLSKIE: ");
        key.addStyle(SGR.BOLD);
        key.setPreferredSize(new TerminalSize(85, 1));
        panel.addComponent(key);

        Label keyy = new Label(drawnKey);
        keyy.addStyle(SGR.BOLD);
        keyy.setForegroundColor(TextColor.ANSI.YELLOW);
        keyy.setPreferredSize(new TerminalSize(85, 1));
        panel.addComponent(keyy);

        Label value = new Label("TŁUMACZENIE ANGIELSKIE: ");
        value.addStyle(SGR.BOLD);
        value.setPreferredSize(new TerminalSize(85, 1));
        panel.addComponent(value);

        Label word = new Label("********");
        word.addStyle(SGR.BOLD);
        word.setForegroundColor(TextColor.ANSI.MAGENTA);
        word.setPreferredSize(new TerminalSize(85, 1));
        panel.addComponent(word);

        Label line = new Label("");
        line.setPreferredSize(new TerminalSize(85, 1));
        panel.addComponent(line);

        Button buttonFirst = new Button("Odkryj tłumaczenie", new Runnable() {
            @Override
            public void run() {
                word.setText(studyController.getDrawnValue(drawnKey));
            }
        });
        panel.addComponent(buttonFirst);

        Button buttonSecond = new Button("Następne słowo", new Runnable() {
            @Override
            public void run(){
                studyController.removeField(drawnKey);
            }
        });
        panel.addComponent(buttonSecond);

        Button buttonThird = new Button("Powrót", new Runnable() {
            @Override
            public void run(){
                try {
                    studyController.getNewMenuView();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        panel.addComponent(buttonThird);

        Button buttonFourth = new Button("Wyzeruj statystyki", new Runnable() {
            @Override
            public void run(){
                studyController.resetData();
                studyController.run();
            }
        });
        panel.addComponent(buttonFourth);
        menuWindow.setComponent(panel);
        Gui.addWindowAndWait(menuWindow);
    }
}
