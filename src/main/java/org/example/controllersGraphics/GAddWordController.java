package org.example.controllersGraphics;
import org.example.viewsGraphics.GAddWordView;

public class GAddWordController extends GController{
    private GAddWordView gAddWordView;
    private GMenuController gMenuController;
    public GAddWordController(GMenuController gMenuController){
        gAddWordView = new GAddWordView(this, jframe);
        this.gMenuController = gMenuController;
    }

    public void run(){
        gAddWordView.ShowAddWordView();
    }

    public static void addWord(String key, String value) {
        GController.addWord(key, value);
    }

    public void getNewMenuView() {
        gMenuController.run();
    }
}
