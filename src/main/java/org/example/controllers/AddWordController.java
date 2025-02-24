package org.example.controllers;
import org.example.views.AddWordView;

import java.io.IOException;

public class AddWordController extends Controller {
    private AddWordView addWordView;
    private MenuController menuController;
    public AddWordController(MenuController menuController){
        addWordView = new AddWordView(this, Gui);
        this.menuController = menuController;
    }

    public void run(){
        addWordView.ShowAddWordView();
    }

    public static void addWord(String key, String value) {
        Controller.addWord(key, value);
    }

    public void getNewMenuView() throws IOException {
        menuController.run();
    }

}
