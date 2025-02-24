package org.example.views;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.gui2.*;
import org.example.controllers.RemoveWordController;

import java.io.IOException;

public class RemoveWordView {
    private RemoveWordController removeWordController;
    private MultiWindowTextGUI Gui;
    public RemoveWordView(RemoveWordController removeWordController, MultiWindowTextGUI Gui) {
        this.removeWordController = removeWordController;
        this.Gui = Gui;

    }

    public void ShowRemoveWordView() {
        Gui.removeWindow(Gui.getActiveWindow());
        BasicWindow menuWindow = new BasicWindow();
        Panel panel = new Panel();
        panel.setPreferredSize(new TerminalSize(85, 25));

        Label label1 = new Label("Aby usunąć fiszkę uzupełnij poniższe pole: ");
        label1.setPreferredSize(new TerminalSize(85, 2));
        panel.addComponent(label1);

        panel.addComponent(new Label("Słowo polskie: "));
        var key = new TextBox().addTo(panel);

        Button buttonFirst = new Button("Potwierdź usunięcie słowa", new Runnable() {
            @Override
            public void run() {
                removeWordController.removeWord(key.getText());
                removeWordController.run();
            }
        });
        panel.addComponent(buttonFirst);

        Button buttonSecond = new Button("Powrót", new Runnable() {
            @Override
            public void run() {
                try {
                    removeWordController.getNewMenuView();
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
