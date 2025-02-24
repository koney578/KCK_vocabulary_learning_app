package org.example.controllers;
import org.example.views.RemoveWordView;

import java.io.IOException;

public class RemoveWordController extends Controller{
    private MenuController menuController;
    private RemoveWordView removeWordView;

    public RemoveWordController(MenuController menuController){
        removeWordView = new RemoveWordView(this, Gui);
        this.menuController = menuController;
    }

    public void run(){
        removeWordView.ShowRemoveWordView();
    }

    public void getNewMenuView() throws IOException {
        menuController.run();
    }

    public static void removeWord(String key) {
        Controller.removeWord(key);
    }
}
