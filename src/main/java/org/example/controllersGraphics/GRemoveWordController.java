package org.example.controllersGraphics;
import org.example.viewsGraphics.GRemoveWordView;

public class GRemoveWordController extends GController{
    private GMenuController gMenuController;
    private GRemoveWordView gRemoveWordView;

    public GRemoveWordController(GMenuController gMenuController){
        gRemoveWordView = new GRemoveWordView(this, jframe);
        this.gMenuController = gMenuController;
    }

    public void run(){
        gRemoveWordView.ShowRemoveWordView();
    }

    public void getNewMenuView() {
        gMenuController.run();
    }

    public static void removeWord(String key) {
        GController.removeWord(key);
    }
}
