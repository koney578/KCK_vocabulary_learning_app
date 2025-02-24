package org.example.views;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.gui2.*;
import org.example.controllers.SummaryController;

import java.io.IOException;

public class SummaryView {

    private SummaryController summaryController;
    private MultiWindowTextGUI Gui;
    public SummaryView(SummaryController summaryController, MultiWindowTextGUI Gui) {
        this.summaryController = summaryController;
        this.Gui = Gui;
    }

    public void ShowSumarry() {
        Gui.removeWindow(Gui.getActiveWindow());
        BasicWindow menuWindow = new BasicWindow();
        Panel panel = new Panel();
        panel.setPreferredSize(new TerminalSize(85, 25));

        Label label1 = new Label("GRATULACJE!");
        label1.addStyle(SGR.BOLD);
        label1.setForegroundColor(TextColor.ANSI.GREEN_BRIGHT);
        label1.setPreferredSize(new TerminalSize(85, 1));
        panel.addComponent(label1);

        Label label2 = new Label("Zaznajomiono wszystkie "+ summaryController.sizeData()+" słów.");
        label2.addStyle(SGR.BLINK);
        label2.setForegroundColor(TextColor.ANSI.CYAN_BRIGHT);
        label2.setPreferredSize(new TerminalSize(85, 1));
        panel.addComponent(label2);

        Button buttonFirst = new Button("Zresetuj postępy i zacznij od nowa!", new Runnable() {
            @Override
            public void run() {
                summaryController.resetData();
                summaryController.getNewStudyView();
            }
        });
        panel.addComponent(buttonFirst);

        Button buttonSecond = new Button("Powrót", new Runnable() {
            @Override
            public void run() {
                try {
                    summaryController.getNewMenuView();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        panel.addComponent(buttonSecond);

        menuWindow.setComponent(panel);
        Gui.addWindowAndWait(menuWindow);
    }
}
