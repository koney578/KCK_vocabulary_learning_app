package org.example.controllersGraphics;
import org.example.viewsGraphics.GSummaryView;

public class GSummaryController extends GController {

    private GSummaryView gSummaryView;
    private GStudyController gStudyController;

    public GSummaryController(GStudyController gStudyController){
        gSummaryView = new GSummaryView(this, jframe);
        this.gStudyController = gStudyController;
    }
    public void run() {
        gSummaryView.ShowSumarry();
    }

    public void getNewMenuView() {
        gStudyController.getNewMenuView();
    }

    public String sizeData() {
        return dataSet.getSizeData();
    }

    public void resetData() {
        gStudyController.resetData();
    }
    public void getNewStudyView() {
        gStudyController.run();
    }
}
