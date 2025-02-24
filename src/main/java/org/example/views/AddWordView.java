package org.example.views;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.gui2.*;
import org.example.controllers.AddWordController;

import java.io.IOException;

public class AddWordView {
    private AddWordController addWordController;
    private MultiWindowTextGUI Gui;
    public AddWordView(AddWordController addWordController, MultiWindowTextGUI Gui){
        this.addWordController = addWordController;
        this.Gui = Gui;
    }
    public void ShowAddWordView(){
        Gui.removeWindow(Gui.getActiveWindow());
        BasicWindow menuWindow = new BasicWindow();
        Panel panel = new Panel();
        panel.setPreferredSize(new TerminalSize(85, 25));

        Label label1 = new Label("Aby dodać nową fiszkę uzupełnij poniższe pola: ");
        label1.setPreferredSize(new TerminalSize(85, 2));
        panel.addComponent(label1);

        panel.addComponent(new Label("Słowo polskie: "));
        var key = new TextBox().addTo(panel);

        panel.addComponent(new Label("Tłumaczenie angielski: "));
        var value = new TextBox().addTo(panel);

        Button buttonFirst = new Button("Potwierdź dodanie słowa", new Runnable() {
            @Override
            public void run() {
                addWordController.addWord(key.getText(), value.getText());
                addWordController.run();
            }
        });
        panel.addComponent(buttonFirst);

        Button buttonSecond = new Button("Powrót", new Runnable() {
            @Override
            public void run() {
                try {
                    addWordController.getNewMenuView();
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
